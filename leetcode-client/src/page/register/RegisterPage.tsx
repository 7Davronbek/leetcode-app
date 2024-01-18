import {useAppDispatch, useAppSelector} from "../../store/store.ts";
import {register} from "../../redux/authSlice.ts";
import {useState} from "react";
import {toast} from "react-toastify";
import {useNavigate} from "react-router-dom";
import http from "../../config";

const RegisterPage = () => {
    const dispatch = useAppDispatch();
    const {user} = useAppSelector(state => state.auth)
    const navigate = useNavigate()

    const [name, setName] = useState<string>(user.name)
    const [surname, setSurname] = useState<string>(user.surname)
    const [phoneNumber, setPhoneNumber] = useState<string>(user.phoneNumber)
    const [password, setPassword] = useState<string>(user.password)
    const [confirmPassword, setConfirmPassword] = useState<string>(user.password)
    const [email, setEmail] = useState<string>(user.email)
    const [birthDate, setBirthDate] = useState<string>(user.birthDate)

    const handleClick = (e: { preventDefault: () => void; }) => {
        e.preventDefault();
        if (password !== confirmPassword) {
            toast.error("Password mismatch.")
            return;
        }
        dispatch(register({name, surname, phoneNumber, password, email, birthDate}))
        validatePhoneNumber()
        navigate("/phone-verify")
    }

    const validatePhoneNumber = async () => {
        await http.post("/user/auth/validate", {phoneNumber})
            .then((res) => {
                toast.success(res.data.message)
            })
            .catch((err) => {
                toast.error(err.message);
                return;
            })
    }
    return (
        <div className="RegisterPage">
            <div className="container">
                <div className="row">
                    <form onSubmit={handleClick} className="col-8 mx-auto">
                        <h5 className="mb-5 text-center">REGISTER</h5>
                        <input placeholder="Name" required value={name} onChange={(e) => setName(e.target.value)}
                               type="text"
                               className="form-control mb-3"/>
                        <input placeholder="Surname" required value={surname}
                               onChange={(e) => setSurname(e.target.value)} type="text"
                               className="form-control mb-3"/>
                        <input placeholder="Phone number" required value={phoneNumber}
                               onChange={(e) => setPhoneNumber(e.target.value)}
                               type="number" className="form-control mb-3"/>
                        <input placeholder="Email" required value={email} onChange={(e) => setEmail(e.target.value)}
                               type="email"
                               className="form-control mb-3"/>
                        <input required value={birthDate} onChange={(e) => setBirthDate(e.target.value)}
                               type="date"
                               className="form-control mb-3"/>
                        <input placeholder="Password" required value={password}
                               onChange={(e) => setPassword(e.target.value)} type="password"
                               className="form-control mb-3"/>
                        <input placeholder="Confirm password" required value={confirmPassword}
                               onChange={(e) => setConfirmPassword(e.target.value)} type="password"
                               className="form-control mb-5"/>
                        <button type="submit" className="btn btn-outline-primary">Register</button>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default RegisterPage;
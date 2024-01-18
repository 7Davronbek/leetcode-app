import {toast} from "react-toastify";
import {useState} from "react";
import {useNavigate} from "react-router-dom";
import http from "../../config";

const LoginPage = () => {
    const [phoneNumber, setPhoneNumber] = useState<string>("")
    const [password, setPassword] = useState<string>("")
    const navigate = useNavigate()

    const handleClick = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();
        await http.post("/user/auth/sing-in",
            {phoneNumber, password}
        )
            .then((res) => {
                console.log(res)
                toast.success("Welcome " + res.data.name)
            })
            .catch((err) => {
                toast.error(err.message);
                return;
            })
        // navigate("/")
    }
    return (
        <div className="LoginPage">
            <div className="container">
                <div className="row">
                    <form onSubmit={handleClick} className="col-8 mx-auto">
                        <h5 className="mb-5 text-center">LOGIN</h5>
                        <input placeholder="Phone number" required value={phoneNumber}
                               onChange={(e) => setPhoneNumber(e.target.value)}
                               type="number" className="form-control mb-3"/>
                        <input placeholder="Password" required value={password}
                               onChange={(e) => setPassword(e.target.value)} type="password"
                               className="form-control mb-3"/>
                        <button type="submit" className="btn btn-outline-dark">Login</button>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default LoginPage;
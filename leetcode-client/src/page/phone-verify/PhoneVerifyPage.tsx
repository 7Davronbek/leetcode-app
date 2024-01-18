import ReactCodeInput from "react-code-input";
import {useState} from "react";
import http from "@/config";
import {useAppSelector} from "../../store/store.ts";
import {toast} from "react-toastify";
import {useNavigate} from "react-router-dom";

const PhoneVerifyPage = () => {
    const {user} = useAppSelector(state => state.auth)
    const navigate = useNavigate()

    const [code, setCode] = useState<string>("")

    const register = async () => {
        await http.post("/user/auth/sing-up", {
            password: user.password,
            name: user.name,
            surname: user.surname,
            phoneNumber: user.phoneNumber,
            email: user.email,
            dateOfBirth: user.birthDate
        }).then((res) => {
            console.log(res.headers)
            // const token = res.headers["Authorization"];
            // console.log(token);
        }).catch((err) => {
            console.log(err)
        })
    }

    const validateCode = async () => {
        await http.post("/user/auth/validate", {
            phoneNumber: user.phoneNumber,
            otp: code
        }).then((res) => {
            toast.success(res.data.message)
            register()
            navigate("/")
        })
            .catch((err) => {
                toast.error(err.message);
                return;
            })
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
        <div className="PhoneVerifyPage">
            <div className="container">
                <div className="row">
                    <div className="col-12 text-center ">
                        <h3 className='mb-4'>Phone verify</h3>
                        <ReactCodeInput value={code} onChange={e => setCode(e)} type='number' fields={5}
                                        inputMode="numeric" name="code verify"/>
                        <button onClick={validatePhoneNumber} className="btn d-block text-center mx-auto mt-3">Re-send
                            code
                        </button>
                        <button onClick={validateCode}
                                className="btn btn-outline-dark d-block text-center mx-auto mt-3">Confirm code
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default PhoneVerifyPage;
import ReactCodeInput from "react-code-input";
import {useEffect, useState} from "react";
import {useAppDispatch, useAppSelector} from "../../store/store.ts";
import {logout} from "../../redux/authSlice.ts";

const Main = () => {
    const [code, setCode] = useState<string>("")
    useEffect(() => {
        if (code.length === 6) {
            console.log("cheese")
        }
    }, [code]);
    const dispatch = useAppDispatch();

    const users = useAppSelector(state => state.auth)
    console.log(users)

    const handleClick = () => {
        dispatch(logout())
    }
    return (
        <div className="Main">
            <div className="container">
                <div className="row">
                    <div className="col-12">
                        <button onClick={handleClick}>Button</button>
                        <ReactCodeInput
                            value={code}
                            onChange={(e) => setCode(e)}
                            type='number'
                            fields={6}
                            inputMode="tel"
                            name="code"
                        />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Main;
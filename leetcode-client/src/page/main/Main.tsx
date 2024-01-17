import ReactCodeInput from "react-code-input";
import {useEffect, useState} from "react";

const Main = () => {
    const [code, setCode] = useState<string>("")
    useEffect(() => {
        if(code.length === 6) {
            console.log("cheese")
        }
    }, [code]);
    return (
        <div className="Main">
            <div className="container">
                <div className="row">
                    <div className="col-12">
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
import {Route, Routes} from "react-router-dom";
import {ToastContainer} from "react-toastify";

import {LoginPage, Main, PhoneVerifyPage, RegisterPage} from "./page";
import {Navbar, ScrollToTop} from "./component";

const App = () => {
    return (
        <>
            <Navbar/>
            <Routes>
                <Route path="/" element={<Main/>}/>
                <Route path="/register" element={<RegisterPage/>}/>
                <Route path="/phone-verify" element={<PhoneVerifyPage/>}/>
                <Route path="/login" element={<LoginPage/>}/>
            </Routes>
            <ToastContainer/>
            <ScrollToTop/>
        </>
    );
};

export default App;
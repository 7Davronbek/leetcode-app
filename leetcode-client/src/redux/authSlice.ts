// eslint-disable-next-line @typescript-eslint/ban-ts-comment
// @ts-expect-error
import {TOKEN} from "@/constant";
import {createSlice} from "@reduxjs/toolkit";
import {IRegisterType} from "../interface";

interface IAuthState {
    isLoading: boolean,
    user: IRegisterType,
    error: string
}

const initialState: IAuthState = {
    isLoading: false,
    user: {
        name: "",
        surname: "",
        phoneNumber: "",
        email: "",
        birthDate: "",
        password: ""
    },
    error: ""
}

export const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {
        logout: (state) => {
            localStorage.removeItem(TOKEN)
        },
        register: (state, {payload}) => {
            console.log(payload)
            state.user.name = payload.name;
            state.user.surname = payload.surname;
            state.user.phoneNumber = payload.phoneNumber;
            state.user.email = payload.email;
            state.user.birthDate = payload.birthDate;
            state.user.password = payload.password;
        }
    },
    // extraReducers: (builder) => {
    //     builder.addCase()
    // }
})

export const {logout, register} = authSlice.actions;
export default authSlice.reducer;
import axiosAll from "./Axios";

class LoginApi {
  static login(userName: string, password: string) {
    const url = "login";

    return axiosAll.get(url, {
      params: { userName: userName, password: password },
    });
  }
}

export default LoginApi;

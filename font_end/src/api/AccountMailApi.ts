import axiosAll from "./Axios";

class AccountMailApi {
  static getAll() {
    const url = "/account-mail/get-all";
    return axiosAll.get(url);
  }
  static addAccountMail(data: any) {
    const url = "/account-mail/add-account-mail";
    return axiosAll.post(url, data);
  }
  static updateStatusMail(id: string) {
    const url = `/account-mail/update-status/${id}`;
    return axiosAll.put(url);
  }
}
export default AccountMailApi;

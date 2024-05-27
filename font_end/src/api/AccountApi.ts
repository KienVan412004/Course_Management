import axiosAll from "../api/Axios";
import type Account from "@type/account";

class AccountApi {
  static getAllAccount() {
    const url = "account/getAll";
    return axiosAll.get(url);
  }
  static addAccount(data: any) {
    const url = "account/add-account";
    return axiosAll.post(url, data);
  }
  static getOne(accountId: string) {
    const url = `account/get-one/${accountId}`;
    return axiosAll.get(url);
  }
  static update(data: any, accountId: string) {
    const url = `account/update-account/${accountId}`;
    return axiosAll.put(url, data);
  }
  static getPageAccount(page: any) {
    const url = "account/get-page";
    return axiosAll.get(url, page);
  }
}

export default AccountApi;

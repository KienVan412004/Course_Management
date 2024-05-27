import axiosAll from "./Axios";

class SendMailApi {
  static addMail(data: any) {
    const url = "mail/add-mail";
    return axiosAll.post(url, data);
  }
  static updateMail(data: any, id: string) {
    const url = `mail/update-mail/${id}`;
    return axiosAll.put(url, data);
  }
  static getAll() {
    const url = "mail/template-mail";
    return axiosAll.get(url);
  }

  static getOne(id: string) {
    const url = `mail/get-one-send-mail/${id}`;
    return axiosAll.get(url);
  }
}

export default SendMailApi;

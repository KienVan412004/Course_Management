import axios from "axios";
import axiosAll from "./Axios";

class TeacherApi {
  static getAll() {
    const url = "teacher/get-all";
    return axiosAll.get(url);
  }
  static getOne(id: string) {
    const url = `teacher/get-one/${id}`;
    return axiosAll.get(url);
  }
  static addTeacher(data: any) {
    const url = "teacher/add-teacher";
    return axiosAll.post(url, data);
  }
  static updateTeacher(data: any, id: string) {
    const url = `teacher/update-teacher/${id}`;
    return axiosAll.put(url, data);
  }
}

export default TeacherApi;

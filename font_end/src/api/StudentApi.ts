import axiosAll from "./Axios";

class StudentApi {
  static getAll() {
    const url = "student/get-all";
    return axiosAll.get(url);
  }
  static getAllCourse() {
    const url = "student/get-all-course";
    return axiosAll.get(url);
  }
  static addStudent(data: any) {
    const url = "student/add-student";
    return axiosAll.post(url, data);
  }
  static getOneStudent(id: string) {
    const url = `student/get-one/${id}`;
    return axiosAll.get(url);
  }
  static updateStudent(data: any, id: string) {
    const url = `student/update-student/${id}`;
    return axiosAll.put(url, data);
  }
  static getStudent(code: string) {
    const url = "student/get-student";
    return axiosAll.get(url, { params: { name: code } });
  }
}
export default StudentApi;

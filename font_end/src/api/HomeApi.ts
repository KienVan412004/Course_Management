import axiosAll from "./Axios";

class HomeApi {
  static getAllCourse() {
    const url = "home/get-all-course";
    return axiosAll.get(url);
  }
  static detailCourse(id: string) {
    const url = `home/detail-course-home/${id}`;
    return axiosAll.get(url);
  }
  static registerCourse(data: any) {
    const url = "home/register-course";
    return axiosAll.post(url, data);
  }
  static getSubjectByCourseId(id: string) {
    const url = `home/get-subject-by-course/${id}`;
    return axiosAll.get(url);
  }
}

export default HomeApi;

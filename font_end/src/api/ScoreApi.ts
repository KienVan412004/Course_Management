import axiosAll from "./Axios";
import type Course from "@type/Course";

class ScoreApi {
  static getAllCourse() {
    const url = "point/get-all-course";
    return axiosAll.get(url);
  }
  static getSubjectByCourse(id: String) {
    const url = `point/get-subject-by-course/${id}`;
    return axiosAll.get(url);
  }
  static getClassByCourse(id: String) {
    const url = `point/get-class-by-course/${id}`;
    return axiosAll.get(url);
  }
  static getStudentByClass(id: String) {
    const url = `point/get-student-by-class/${id}`;
    return axiosAll.get(url);
  }
  static getIdStudentByClass(id: String) {
    const url = `point/get-idStudent-by-idClass/${id}`;
    return axiosAll.get(url);
  }
  static addPointStudent(data: any) {
    const url = "point/add-point-student";
    return axiosAll.post(url, data);
  }
  static getAllPoint() {
    const url = "point/get-all";
    return axiosAll.get(url);
  }
  static getClassByStudent(id: string) {
    const url = `point/get-class-teacher/${id}`;
    return axiosAll.get(url);
  }
  static getSubjectByClass(id: string) {
    const url = `point/get-subject-by-class/${id}`;
    return axiosAll.get(url);
  }
  static getPointStudent(subjectId: any, classId: string) {
    const url = `point/get-point-student/${classId}`;
    return axiosAll.get(url, { params: { subjectId: subjectId } });
  }

  static getPointStudentById(id: string) {
    const url = `point/get-point-student-by-id/${id}`;
    return axiosAll.get(url);
  }
  static changeStatus(subjectId: string, classId: string) {
    const url = `point/change-status/${subjectId}/${classId}`;
    return axiosAll.put(url);
  }
}
export default ScoreApi;

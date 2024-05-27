import axiosAll from "../api/Axios";
import type Course from "@/types/Course";
import type Stduent from "@/types/Student";

class CourseApi {
  static getAll() {
    const url = "course/get-all";
    return axiosAll.get(url);
  }
  static getAllStudent() {
    const url = "course/get-all-student";
    return axiosAll.get(url);
  }
  static addCourse(data: any) {
    const url = "course/add-course";
    return axiosAll.post(url, data);
  }
  static getOne(courseId: string) {
    const url = `course/get-one/${courseId}`;
    return axiosAll.get(url);
  }
  static getStudentByCourseId(courseId: string) {
    const url = `course/get-student-by-course/${courseId}`;
    return axiosAll.get(url);
  }
  static getSubjectByCourseId(courseId: string) {
    const url = `course/get-subject-by-course/${courseId}`;
    return axiosAll.get(url);
  }
}
export default CourseApi;

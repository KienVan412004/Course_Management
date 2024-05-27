import axios from "axios";
import axiosAll from "./Axios";

class ClassesApi {
  static getAll() {
    const url = "classes/get-all";
    return axiosAll.get(url);
  }
  static getAllStudent() {
    const url = "classes/get-all-student";
    return axiosAll.get(url);
  }
  static getOne(id: String) {
    const url = `classes/get-one/${id}`;
    return axiosAll.get(url);
  }
  static getStudentByClass(id: String) {
    const url = `classes/get-student-by-class/${id}`;
    return axiosAll.get(url);
  }
  static addClass(data: any) {
    const url = "classes/add-class-by-subject";
    return axiosAll.post(url, data);
  }
  static addStudentToClass(data: any) {
    const url = "classes/add-student-to-class";
    return axiosAll.post(url, data);
  }
  static getAllCourse() {
    const url = "classes/get-all-course";
    return axiosAll.get(url);
  }
  static getAllTeacher() {
    const url = "classes/get-all-teacher";
    return axiosAll.get(url);
  }
  static addClassToCourse(data: any) {
    const url = "classes/add-class-to-course";
    return axiosAll.post(url, data);
  }

  static exportExcel() {
    const url = "classes/export-excel";
    return axiosAll.post(url);
  }
  static getClassByTeacher(id: String) {
    const url = `classes/get-class-by-teacher/${id}`;
    return axiosAll.get(url);
  }
}

export default ClassesApi;

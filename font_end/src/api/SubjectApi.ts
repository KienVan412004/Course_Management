import axiosAll from "./Axios";
import type Subject from "@/types/Subject";

class SubjectApi {
  static getOne(id: string) {
    const url = `subject/get-one/${id}`;
    return axiosAll.get(url);
  }
  static getClassBySubjectId(id: string) {
    const url = `subject/get-class-by-subject-id/${id}`;
    return axiosAll.get(url);
  }
  static addSubjectByCourse(data: any) {
    const url = "subject/add-subject-by-course";
    return axiosAll.post(url, data);
  }
  static getSubjectById(id: string) {
    const url = `subject/get-subject-by-id/${id}`;
    return axiosAll.get(url);
  }
}

export default SubjectApi;

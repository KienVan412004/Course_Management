<template>
  <div class="account">
    <div class="container" style="padding-top: 40px">
      <div style="height: 700px; background-color: white; border-radius: 20px">
        <p style="font-size: 25px; font-weight: bold; padding: 15px">
          <img src="/img/pen2.png" alt="" width="50px" /> Quản lý điểm
        </p>
        <hr />
        <div class="container">
          <div class="row">
            <div class="col-6">
              <input
                type="text"
                id="inputPassword5"
                class="form-control"
                aria-describedby="passwordHelpBlock"
                style="
                  width: 70%;

                  border-radius: 20px;
                  height: 40px;
                "
                placeholder="Tìm kiếm ..."
              />
            </div>
            <div class="col-2">
              <input
                type="date"
                id="inputPassword5"
                class="form-control"
                aria-describedby="passwordHelpBlock"
                style="width: 100%; border-radius: 20px; height: 40px"
                placeholder="Tìm kiếm ..."
              />
            </div>
            <div class="col-2">
              <input
                type="date"
                id="inputPassword5"
                class="form-control"
                aria-describedby="passwordHelpBlock"
                style="width: 100%; border-radius: 20px; height: 40px"
                placeholder="Tìm kiếm ..."
              />
            </div>
            <div class="col-2">
              <button
                type="button"
                class="btn btn-primary"
                data-bs-toggle="modal"
                data-bs-target="#exampleModal"
                style="
                  width: 140px;
                  height: 45px;
                  border-radius: 20px;
                  background-color: #ffa726;
                  border: none;
                  font-weight: 700;
                "
              >
                Thêm mới
              </button>
            </div>
          </div>
          <div>
            <table class="table" style="margin-top: 50px">
              <thead style="background-color: gray">
                <tr>
                  <th scope="col">Stt</th>
                  <th scope="col">Tên Lớp học</th>
                  <th scope="col">Tên sinh viên</th>
                  <th scope="col">Mã sinh viên</th>
                  <th scope="col">Điểm</th>
                  <th scope="col">Môn học</th>
                  <th scope="col">Hành động</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(item, index) in getAllPoint" :key="item.id">
                  <th>{{ index + 1 }}</th>
                  <th>{{ item.classes.className }}</th>
                  <th>{{ item.student.fullName }}</th>
                  <th>{{ item.student.code }}</th>
                  <th>{{ item.pointStudent }}</th>
                  <th>{{ item.subject.subjectName }}</th>
                  <th>
                    <button
                      type="button"
                      class="btn btn-info"
                      style="background-color: #189a2e; border-radius: 15px"
                    >
                      <img src="/img/icons8-eye-24.png" alt="" />
                    </button>
                  </th>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <!-- Modal -->
    <div
      class="modal fade"
      id="exampleModal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <p style="font-size: 20px; font-weight: bold; padding: 15px">
              <img src="/img/pen2.png" alt="" width="30px" /> Thêm mới điểm
            </p>
          </div>
          <div class="modal-body">
            <p style="font-weight: bold; margin-top: 20px; text-align: center">
              Tên Khoá học <span style="color: red">*</span>
            </p>
            <div
              style="
                display: flex;
                align-items: center;
                justify-content: center;
              "
            >
              <select
                v-model="selectedCourseId"
                style="width: 300px"
                class="form-select"
                aria-label="Default select example"
                @change="handleSelectedCourse"
              >
                <option
                  v-for="item in getAllCourse"
                  :key="item.id"
                  :value="item.id"
                >
                  {{ item.name }}
                </option>
              </select>
            </div>
            <div class="row">
              <div class="col-6">
                <p
                  style="
                    font-weight: bold;
                    margin-top: 20px;
                    text-align: center;
                  "
                >
                  Tên môn học <span style="color: red">*</span>
                </p>

                <select
                  class="form-select"
                  aria-label="Default select example"
                  v-model="selectedSubjectId"
                  @change="handleSelectedSubject"
                >
                  <option
                    v-for="item in getSubjectByCourse"
                    :key="item.id"
                    :value="item.id"
                  >
                    {{ item.subjectName }}
                  </option>
                </select>
              </div>
              <div class="col-6">
                <p
                  style="
                    font-weight: bold;
                    margin-top: 20px;
                    text-align: center;
                  "
                >
                  Tên Lớp học <span style="color: red">*</span>
                </p>

                <select
                  class="form-select"
                  aria-label="Default select example"
                  v-model="selectedClass"
                  @change="handleSelectedClass"
                >
                  <option
                    v-for="item in getClassByCourse"
                    :key="item.id"
                    :value="item.id"
                  >
                    {{ item.className }}
                  </option>
                </select>
              </div>
            </div>
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Mã sinh viên</th>
                  <th scope="col">Họ và tên</th>
                  <th>Điểm</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(item, index) in getStudentByClass" :key="item.id">
                  <th scope="row">{{ index + 1 }}</th>
                  <td>{{ item.code }}</td>
                  <td>{{ item.fullName }}</td>
                  <td
                    contenteditable="true"
                    @input="handleScoreChange(index, $event)"
                  >
                    {{ getEditedScore(index) }}
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-bs-dismiss="modal"
              style="
                width: 130px;
                border-radius: 10px;
                background-color: #f3f6f9;
                border: none;
                color: black;
              "
            >
              Hủy
            </button>
            <button
              type="button"
              class="btn btn-primary"
              style="
                width: 130px;
                border-radius: 10px;
                background-color: #ffa726;
                border: none;
                color: black;
              "
              @click="handleAddPointStudent"
            >
              Xác nhận
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import Vue, { ref, watchEffect } from "vue";
import Course from "../../types/Course";
import ScoreApi from "../../api/ScoreApi";
import { log } from "console";
import type Subject from "@/types/Subject";
import type Classes from "@/types/Classes";
import type Studuent from "@/types/Student";
import type AddPointStudent from "@/types/AddpointStudent";
import type Point from "@/types/Point";

const getAllCourse = ref<Course[]>([]);
const getSubjectByCourse = ref<Subject[]>([]);
const getClassByCourse = ref<Classes[]>([]);
const getStudentByClass = ref<Studuent[]>([]);
const getIdStudentByClass = ref<String[]>([]);
const selectedClass = ref<String>("");
const selectedCourseId = ref<String>("");
const selectedSubjectId = ref<String>("");
const editScore = ref<String[]>([]);
const getAllPoint = ref<Point[]>([]);
const addPointStudent = ref<AddPointStudent>({
  studentId: [],
  point: [],
  classId: "",
  subjectId: "",
});

const handleGetAllPoint = () => {
  ScoreApi.getAllPoint().then((response) => {
    getAllPoint.value = response.data;
    console.log(response.data);
  });
};

const handleAddPointStudent = () => {
  ScoreApi.addPointStudent(addPointStudent.value).then((response) => {
    handleGetAllPoint();
  });
};

const handleGetAllCourse = () => {
  ScoreApi.getAllCourse().then((response) => {
    getAllCourse.value = response.data;
  });
};

const handleGetSujectByCourse = (id: String) => {
  ScoreApi.getSubjectByCourse(id).then((response) => {
    getSubjectByCourse.value = response.data;
  });
};

const handleGetClassByCourse = (id: String) => {
  ScoreApi.getClassByCourse(id).then((response) => {
    getClassByCourse.value = response.data;
  });
};

const handleGetStudentByClass = (id: String) => {
  ScoreApi.getStudentByClass(id).then((response) => {
    getStudentByClass.value = response.data;

    editScore.value = Array(getStudentByClass.value.length).fill("0");
    addPointStudent.value.studentId = getIdStudentByClass.value;
    addPointStudent.value.point = editScore.value;
    console.log(editScore.value, "editScore.value");
    console.log(getStudentByClass.value);
  });
};
const handleGetIdStudentByClass = (id: String) => {
  ScoreApi.getIdStudentByClass(id).then((response) => {
    getIdStudentByClass.value = response.data;
    console.log(response.data);
  });
};

const handleSelectedSubject = () => {
  addPointStudent.value.subjectId = selectedSubjectId.value;
};
const handleSelectedClass = () => {
  handleGetStudentByClass(selectedClass.value);
  handleGetIdStudentByClass(selectedClass.value);
  addPointStudent.value.classId = selectedClass.value;
};

const handleSelectedCourse = () => {
  handleGetSujectByCourse(selectedCourseId.value);
  handleGetClassByCourse(selectedCourseId.value);
};
const handleScoreChange = (index: number, event: Event) => {
  // Cập nhật giá trị điểm đã chỉnh sửa vào mảng editedScores
  editScore.value[index] = (event.target as HTMLTableCellElement).innerText;
  console.log(editScore.value, "editScore.value");
};
const getEditedScore = (index: number) => {
  // Lấy giá trị điểm đã chỉnh sửa từ mảng editedScores
  return editScore.value[index];
};

console.log(editScore.value, "editScore.value");

watchEffect(() => {
  handleGetAllCourse();
  handleGetAllPoint();
});
</script>

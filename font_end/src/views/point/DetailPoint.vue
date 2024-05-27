<template>
  <div class="account">
    <div class="container">
      <div
        style="
          height: 700px;
          background-color: white;
          border-radius: 20px;
          padding-top: 50px;
        "
      >
        <div class="container">
          <div class="row">
            <div class="col-3"></div>

            <div class="col-4">
              <select
                class="form-select"
                aria-label="Default select example"
                v-model="selectedSubject"
                @change="handleSelectedSubject"
              >
                <option
                  v-for="item in getSubjectByClass"
                  :key="item.id"
                  :value="item.id"
                >
                  {{ item.subjectName }}
                </option>
              </select>
            </div>
            <!-- <div class="col-2">
              <button
                type="button"
                class="btn btn-primary"
                style="
                  width: 140px;
                  height: 45px;
                  border-radius: 20px;
                  background-color: #ffa726;
                  border: none;
                  font-weight: 700;
                "
                @click="handleAddPointStudent"
              >
                Thêm mới
              </button>
            </div> -->
          </div>
          <div>
            <button
              v-if="checkUpdate"
              type="button"
              class="btn btn-primary"
              style="
                width: 140px;
                height: 35px;
                border-radius: 15px;
                background-color: #ffa726;
                border: none;
                font-weight: 600;
                float: right;
              "
              @click="HandleEditTable"
            >
              Cập nhật điểm
            </button>
            <!-- <button
              type="button"
              class="btn btn-primary"
              style="
                width: 140px;
                height: 35px;
                border-radius: 15px;
                background-color: #ffa726;
                border: none;
                font-weight: 600;
                float: right;
              "
              @click="handleChangeStatus"
            >
              Mở lớp
            </button> -->
            <table class="table" style="margin-top: 50px">
              <thead style="background-color: gray">
                <tr>
                  <th scope="col">Stt</th>
                  <th scope="col">Mã sinh viên</th>
                  <th scope="col">Tên sinh viên</th>
                  <th scope="col">Điểm</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(item, index) in getPointStudent" :key="item.id">
                  <th>{{ index + 1 }}</th>
                  <td>{{ item.code }}</td>
                  <td>{{ item.fullName }}</td>
                  <td
                    :contenteditable="isEditTable"
                    @input="handleScoreChange(index, $event)"
                  >
                    {{ item.pointStudent == 0 ? "" : item.pointStudent }}
                  </td>
                </tr>
              </tbody>
            </table>

            <button
              type="button"
              v-if="isEditTable"
              class="btn btn-primary"
              style="
                width: 130px;
                height: 40px;
                border-radius: 15px;
                background-color: #0a58cd;
                border: none;
                font-weight: 700;
                float: right;
              "
              @click="handleAddPointStudent"
            >
              Cập nhật
            </button>
          </div>
        </div>
      </div>
    </div>
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
                  v-model="selectedSubject"
                  @change="handleSelectedSubject"
                >
                  <option
                    v-for="item in getSubjectByClass"
                    :key="item.id"
                    :value="item.id"
                  >
                    {{ item.subjectName }}
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
import ScoreApi from "@/api/ScoreApi";
import type AddPointStudent from "@/types/AddpointStudent";
import type GetPointStudent from "@/types/GetPointStudent";
import type Studuent from "@/types/Student";
import type Subject from "@/types/Subject";
import Vue, { computed, ref, watch, watchEffect } from "vue";
import { useRoute } from "vue-router";
import Menu from "../../layout/Menu.vue";
import SubjectApi from "@/api/SubjectApi";
const router = useRoute();
const getSubjectByClass = ref<Subject[]>([]);
const getStudentByClass = ref<Studuent[]>([]);
const selectedSubject = ref<String>("");
const editScore = ref<String[]>([]);
const getPoint = ref<String[]>([]);
const getIdStudentByClass = ref<String[]>([]);
const getPointStudent = ref<GetPointStudent[]>([]);
const isEditTable = ref(false);
const getSelectedSubject = ref<String>("");
const getSubjectById = ref<String>("");
const checkUpdate = ref(false);

const addPointStudent = ref<AddPointStudent>({
  studentId: [],
  point: [],
  classId: router.params.id,
  subjectId: "",
});

const handleGetSubjectById = () => {
  SubjectApi.getSubjectById(selectedSubject.value).then((response) => {
    getSubjectById.value = response.data;
    console.log(response.data, "getStatus");
    if (response.data.status === 1) {
      checkUpdate.value = true;
    } else {
      checkUpdate.value = false;
    }
  });
};

const handleChangeStatus = () => {
  ScoreApi.changeStatus(selectedSubject.value, router.params.id).then(() => {});
};

const HandleEditTable = () => {
  isEditTable.value = !isEditTable.value;
};

const handleGetPointStudent = (id: string) => {
  ScoreApi.getPointStudent(getSelectedSubject.value, id).then((response) => {
    getPointStudent.value = response.data;
    console.log(response.data, "getpoint");

    const points = response.data.map(
      (item: GetPointStudent) => item.pointStudent
    );
    getPoint.value = points;
    if (editScore.value.length !== points.length) {
      editScore.value = Array(points.length).fill("0");
    }

    // Lặp qua từng phần tử của mảng editScore
    // Nếu phần tử tại chỉ số i chưa được sửa, thì cập nhật lại giá trị của nó từ points
    for (let i = 0; i < editScore.value.length; i++) {
      if (editScore.value[i] === "0") {
        editScore.value[i] = points[i] !== undefined ? points[i] : "0";
      }
    }
  });
};

const handleAddPointStudent = () => {
  ScoreApi.addPointStudent(addPointStudent.value).then((response) => {
    handleGetPointStudent(router.params.id);
    isEditTable.value = false;
  });
};

const handleGetIdStudentByClass = (id: String) => {
  ScoreApi.getIdStudentByClass(id).then((response) => {
    getIdStudentByClass.value = response.data;
    addPointStudent.value.studentId = response.data;
  });
};

const handleGetStudentByClass = (id: String) => {
  ScoreApi.getStudentByClass(id).then((response) => {
    getStudentByClass.value = response.data;

    editScore.value = Array(getStudentByClass.value.length).fill("0");
    addPointStudent.value.point = editScore.value;
  });
};

const handleGetSubjectByClass = (id: string) => {
  ScoreApi.getSubjectByClass(id).then((response) => {
    getSubjectByClass.value = response.data;
  });
};

const handleScoreChange = (index: number, event: Event) => {
  // Cập nhật giá trị điểm đã chỉnh sửa vào mảng editedScores
  editScore.value[index] = (event.target as HTMLTableCellElement).innerText;
};
const getEditedScore = (index: number) => {
  // Lấy giá trị điểm đã chỉnh sửa từ mảng editedScores
  return editScore.value[index];
};
const handleSelectedSubject = () => {
  addPointStudent.value.subjectId = selectedSubject.value;
  getSelectedSubject.value = selectedSubject.value;
  handleGetSubjectById();
};

watch(getSelectedSubject, (newValue, oldValue) => {
  handleGetPointStudent(router.params.id);
});

watchEffect(() => {
  handleGetSubjectByClass(router.params.id);
  handleGetStudentByClass(router.params.id);
  handleGetIdStudentByClass(router.params.id);
});
</script>

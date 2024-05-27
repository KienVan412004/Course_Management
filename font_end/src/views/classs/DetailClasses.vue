<template>
  <Menu>
    <div class="container">
      <p style="font-size: 25px; font-weight: bold; padding: 15px">
        <img src="/img/pen2.png" alt="" width="50px" /> Chi tiết lớp học
      </p>
      <div class="content-detail-classes">
        <div class="row container">
          <div class="col-5">
            <div class="row">
              <div class="col-8">
                <p style="font-weight: bold; margin-top: 20px">
                  Tên lớp học <span style="color: red">*</span>
                </p>
                <input
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  placeholder="Họ và tên"
                  v-model="getOne.className"
                />
              </div>
              <div class="col-4">
                <div class="form-check form-switch" style="margin-top: 65px">
                  <input
                    class="form-check-input"
                    type="checkbox"
                    role="switch"
                    id="flexSwitchCheckChecked"
                    checked
                    @change="handleShowStudentList"
                  />
                  <label class="form-check-label" for="flexSwitchCheckChecked"
                    >Hiển thị</label
                  >
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-6">
                <p style="font-weight: bold; margin-top: 20px">
                  Mã lớp học <span style="color: red">*</span>
                </p>
                <input
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  v-model="getOne.classCode"
                />
              </div>
              <div class="col-6">
                <p style="font-weight: bold; margin-top: 20px">
                  Ngày khai giảng <span style="color: red">*</span>
                </p>
                <input
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  v-model="getOne.startDate"
                />
              </div>
            </div>

            <p style="font-weight: bold; margin-top: 20px">
              Tên giảng viên <span style="color: red">*</span>
            </p>
            <input
              type="text"
              class="form-control"
              id="exampleFormControlInput1"
              placeholder="Họ và tên"
              v-model="getOne.teacher.fullName"
            />
            <p style="font-weight: bold; margin-top: 20px">
              Tên Khóa học <span style="color: red">*</span>
            </p>
            <input
              type="text"
              class="form-control"
              id="exampleFormControlInput1"
              placeholder="Họ và tên"
              v-model="getOne.course.name"
            />
            <button
              type="button"
              class="btn btn-primary"
              style="
                width: 130px;
                border-radius: 10px;
                background-color: #ffa726;
                border: none;
                color: white;
                font-weight: 600;
                margin-top: 60px;
              "
              @click="handleAddStudentToClass()"
            >
              Cập nhật
            </button>
          </div>
          <div class="col-7">
            <p style="font-size: 25px; font-weight: bold; padding: 15px">
              <img src="/img/danh_sach.png" alt="" width="50px" /> Danh sách
              sinh viên
              <button
                type="button"
                class="btn btn-primary"
                data-bs-toggle="modal"
                data-bs-target="#exampleModal"
                style="
                  width: 50px;
                  height: 45px;
                  border-radius: 10px;
                  background-color: #ffa726;
                  border: none;
                  font-weight: 700;
                  float: right;
                "
              >
                <img src="/img/import.png" alt="" />
              </button>
            </p>

            <div class="container">
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Họ và tên</th>
                    <th scope="col">Ngày sinh</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="item in getAllStudent" :key="item.id">
                    <th scope="row">
                      <input
                        type="checkbox"
                        name=""
                        id=""
                        :value="item.id"
                        v-model="selectedStudent"
                      />
                    </th>
                    <td>{{ item.code }}</td>
                    <td>{{ item.fullName }}</td>
                    <td>{{ fomartDate(item.dateOfBirth) }}</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      <div class="classmates" v-show="showStudentList">
        <p style="font-size: 25px; font-weight: bold; padding: 15px">
          <img src="/img/classmates-removebg-preview.png" alt="" width="50px" />
          Sinh viên trong lớp
        </p>
        <div class="student-in-class">
          <div class="container">
            <div class="row">
              <div
                class="col-3"
                v-for="item in getStudentByClassId"
                :key="item.id"
              >
                <div class="student-course-classmates">
                  <div class="avata-student-classmates">
                    <img src="/img/icons8-user-24.png" alt="" />
                  </div>
                  <span style="font-weight: 600; padding: 5px">
                    {{ item.fullName }} - {{ item.code }}</span
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- Modal import-->
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
              <p style="font-size: 25px; font-weight: bold; padding: 15px">
                <img src="/img/pen2.png" alt="" width="30px" /> Import sinh viên
              </p>
            </div>
            <div class="modal-body">
              <input
                type="file"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="Họ và tên"
                @change="importExcelStudentToClass"
              />
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
                @click="exportToExcel"
              >
                Emport
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
                @click="handleAddStudentToClass()"
              >
                Import
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </Menu>
</template>
<script setup lang="ts">
import ClassesApi from "@/api/ClassesApi";
import type AddStudentToClass from "@/types/AddStudentToClass";
import type Classes from "@/types/Classes";
import type Stduent from "@/types/Student";
import dayjs from "dayjs";
import Vue, { ref, watchEffect } from "vue";
import { useRoute } from "vue-router";
import { log } from "util";
import Studuent from "../../types/Student";
import * as ExcelJS from "exceljs";
import * as XLSX from "xlsx";
import { watch } from "vue";
import Menu from "../../layout/Menu.vue";

const getOne = ref<Classes[]>([]);
const getAllStudent = ref<Stduent[]>([]);
const selectedStudent = ref<string[]>([]);
const getStudentByClassId = ref<Studuent[]>([]);
const router = useRoute();

const importExcelStudentToClass = (e: any) => {
  alert("gọi ròi");
  const file = e.target.files[0];
  const reader = new FileReader();

  reader.onload = (e: any) => {
    const data = new Uint8Array(e.target.result);
    const workbook = XLSX.read(data, { type: "array" });
    const worksheet = workbook.Sheets[workbook.SheetNames[0]];
    const raw_data = XLSX.utils.sheet_to_json(worksheet, { header: 1 });
    raw_data.shift();

    // Lặp qua từng dòng dữ liệu và thêm id vào selectedStudent.value
    raw_data.forEach((row: any) => {
      const studentId = row[1]; // Giả sử cột 'Mã sinh viên' là cột 2
      selectedStudent.value.push(studentId);
    });

    // Sau khi thêm tất cả các id vào selectedStudent.value, bạn có thể cập nhật giá trị cho addStudentToClass.value.studentId nếu cần
    addStudentToClass.value.studentId = selectedStudent.value;
    console.log(selectedStudent.value);
  };
  reader.readAsArrayBuffer(file);
};

const showStudentList = ref(true);

const exportToExcel = () => {
  const workbook = new ExcelJS.Workbook();
  const worksheet = workbook.addWorksheet("Import Student");

  const columns = [
    { header: "STT", key: "stt", width: 5 },
    { header: "Mã sinh viên", key: "code", width: 30 },
    { header: "Mã lớp", key: "classCode", width: 30 },
  ];

  worksheet.columns = columns;
  const titleStyle = {
    font: { bold: true, color: { argb: "FFFFFF" } },
    fill: {
      type: "pattern",
      pattern: "solid",
      fgColor: { argb: "FF008080" },
    },
  };

  worksheet.getRow(1).eachCell((cell) => {
    cell.style = titleStyle;
  });

  worksheet.columns.forEach((column) => {
    const { width } = column;
    column.width = width;
  });

  const blob = workbook.xlsx.writeBuffer().then(
    (buffer) =>
      new Blob([buffer], {
        type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
      })
  );

  blob.then((blobData) => {
    const url = window.URL.createObjectURL(blobData);
    const link = document.createElement("a");
    link.href = url;
    link.download = "Student_data.xlsx";
    link.click();
  });
};

console.log(selectedStudent.value);

const handleShowStudentList = () => {
  showStudentList.value = !showStudentList.value; // Đảo ngược giá trị của biến khi checkbox được thay đổi
};

const addStudentToClass = ref<AddStudentToClass>({
  id: "",
  classId: router.params.id,
  studentId: selectedStudent.value,
});

const handleGetStudentByClass = (id: String) => {
  ClassesApi.getStudentByClass(id).then((response) => {
    getStudentByClassId.value = response.data;
  });
};

// const handleCheckBoxStudentId = (studentId) => {
//   if (selectedStudent.value.includes(studentId)) {
//     selectedStudent.value = selectedStudent.value.filter(
//       (id) => id != studentId
//     );
//   } else {
//     selectedStudent.value.push(studentId);
//   }
//   console.log(selectedStudent.value);
// };

const handleAddStudentToClass = () => {
  ClassesApi.addStudentToClass(addStudentToClass.value).then((response) => {
    handleGetStudentByClass(router.params.id);
    selectedStudent.value = [];
  });
};

const fomartDate = (date: Date) => {
  return dayjs(date).format("DD/MM/YYYY");
};

const handleGetAllStudent = () => {
  ClassesApi.getAllStudent().then((response) => {
    getAllStudent.value = response.data;
  });
};

const handleGetOne = (id: String) => {
  ClassesApi.getOne(id).then((response) => {
    getOne.value = response.data;
    console.log(response.data, "get one class");
  });
};
watch(selectedStudent, () => {
  addStudentToClass.value.studentId = selectedStudent.value;
});

watchEffect(() => {
  handleGetOne(router.params.id);
  handleGetAllStudent();
  handleGetStudentByClass(router.params.id);
});
</script>
<style scoped>
.content-detail-classes {
  background-color: white;
  padding: 5px;
  border-radius: 30px;
  height: 540px;
}
.student-course {
  height: 85px;
  margin-bottom: 30px;
  border: 1px solid #ffa726;
  border-radius: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.student-course-classmates {
  height: 50px;
  margin-bottom: 30px;
  border: 1px solid #0288d1;
  border-radius: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.avata-student-classmates {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #0288d1;
  display: flex;
  align-items: center;
  justify-content: center;
}
.student-in-class {
  background-color: white;
  padding: 30px;
  border-radius: 30px;
}
</style>

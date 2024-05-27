<template>
  <Menu>
    <div class="container">
      <p style="font-size: 25px; font-weight: bold; padding: 15px">
        <img src="/img/pen2.png" alt="" width="50px" /> Chi tiết môn học
      </p>
      <div class="content-detail-subject">
        <div class="row container">
          <div class="col-6">
            <p style="font-weight: bold; margin-top: 20px">
              Tên môn học <span style="color: red">*</span>
            </p>
            <input
              type="text"
              class="form-control"
              id="exampleFormControlInput1"
              placeholder="Họ và tên"
              v-model="getOneSubject.subjectName"
            />
            <p style="font-weight: bold; margin-top: 20px">
              Mã môn học <span style="color: red">*</span>
            </p>
            <input
              type="text"
              class="form-control"
              id="exampleFormControlInput1"
              v-model="getOneSubject.subjectCode"
            />

            <p style="font-weight: bold; margin-top: 20px">
              Lộ trình <span style="color: red">*</span>
            </p>

            <span
              class="form-control"
              id="exampleFormControlTextarea1"
              rows="3"
              style="height: 250px"
              v-html="getOneSubject.description"
            ></span>
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
            >
              Cập nhật
            </button>
          </div>
          <div class="col-6">
            <!-- <p style="font-size: 25px; font-weight: bold; padding: 15px">
            <img src="/img/danh_sach.png" alt="" width="50px" /> Danh sách lớp
            học
            <img
              src="/img/plus.png"
              data-bs-toggle="modal"
              data-bs-target="#exampleModal"
              alt=""
              width="30px"
              style="float: right"
            />
          </p>
          <div class="container">
            <div class="row">
              <div
                class="col-6"
                v-for="item in getClassBySubjectId"
                :key="item.id"
              >
                <router-link
                  class="linkClass"
                  :to="`/detail-classes/${item.id}`"
                >
                  <div class="student-course">
                    <div class="avata-student">
                      <img
                        style="margin-right: 10px"
                        src="/img/class.png"
                        alt=""
                        width="50"
                      />
                    </div>
                    <span style="font-weight: 600; padding: 5px">
                      Lớp học: {{ item.className }} <br />
                      Mã Lớp: {{ item.classCode }}</span
                    >
                  </div>
                </router-link>
              </div>
            </div>
          </div> -->
            <p style="font-weight: bold; margin-top: 20px">
              Ngày bắt đầu <span style="color: red">*</span>
            </p>
            <input
              type="text"
              class="form-control"
              id="exampleFormControlInput1"
              placeholder="Họ và tên"
              v-model="getOneSubject.startDate"
            />
            <p style="font-weight: bold; margin-top: 20px">
              Ngày kết thúc <span style="color: red">*</span>
            </p>
            <input
              type="text"
              class="form-control"
              id="exampleFormControlInput1"
              v-model="getOneSubject.endDate"
            />
            <p style="font-weight: bold; margin-top: 20px">
              Kết quả sau khi học<span style="color: red">*</span>
            </p>
            <input
              type="text"
              class="form-control"
              id="exampleFormControlInput1"
              v-model="getOneSubject.result"
            />
          </div>
        </div>
      </div>
      <!-- Modal add class-->
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
                <img src="/img/pen2.png" alt="" width="30px" /> Thêm mới lớp học
              </p>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div class="modal-body">
              <p style="font-weight: bold; margin-top: 20px">
                Tên lớp học <span style="color: red">*</span>
              </p>
              <input
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                style="width: 80%"
                v-model="addClassByIdSubject.className"
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
                @click="handleAddClassBySubject"
              >
                Xác nhận
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </Menu>
</template>
<script setup lang="ts">
import type Classes from "@/types/Classes";
import SubjectApi from "../../api/SubjectApi";
import type Subject from "@/types/Subject";
import Vue, { ref, watchEffect } from "vue";
import { useRoute } from "vue-router";
import ClassesApi from "@/api/ClassesApi";
import Menu from "../../layout/Menu.vue";

const getOneSubject = ref<Subject>();

const getClassBySubjectId = ref<Classes>();
const router = useRoute();
const addClassByIdSubject = ref<Classes>({
  id: "",
  className: "",
  classCode: "",
  subjectId: router.params.id,
});

const getAllClass = ref<Classes[]>([]);

const handleAddClassBySubject = () => {
  ClassesApi.addClass(addClassByIdSubject.value).then((response) => {
    handleGetClassBySubjectId(router.params.id);
  });
};

const handleGetAllClass = () => {
  ClassesApi.getAll().then((response) => {
    getAllClass.value = response.data;
  });
};

const handleGetClassBySubjectId = (id: String) => {
  SubjectApi.getClassBySubjectId(id).then((response) => {
    getClassBySubjectId.value = response.data;
  });
};

const handleGetOne = (id: String) => {
  SubjectApi.getOne(id).then((response) => {
    getOneSubject.value = response.data;
    console.log(response.data, "get one subject");
  });
};

watchEffect(() => {
  handleGetOne(router.params.id);
  handleGetAllClass();
  handleGetClassBySubjectId(router.params.id);
});
</script>
<style scoped>
.linkClass {
  text-decoration: none;
  color: black;
}
.content-detail-subject {
  background-color: white;
  padding: 40px;
  border-radius: 30px;
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

.avata-student {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #ffa726;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>

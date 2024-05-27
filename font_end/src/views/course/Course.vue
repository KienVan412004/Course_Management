<template>
  <Menu>
    <div class="container" style="padding-top: 20px">
      <div>
        <p style="font-size: 25px; font-weight: bold; padding: 15px">
          <img src="/img/pen2.png" alt="" width="50px" /> Quản lý khóa học
          <img
            src="/img/plus.png"
            data-bs-toggle="modal"
            data-bs-target="#exampleModal"
            alt=""
            width="50px"
            style="float: right"
          />
        </p>

        <!-- <div class="row" style="overflow-y: scroll; max-height: 510px">
        <div class="col-4" v-for="item in getAll" :key="item.id">
          <router-link :to="`/detail-course/${item.id}`">
            <div class="courses">
              <p class="title-course">{{ item.name }}</p>
              <p class="time-course">
                {{ fomartDate(item.startDate) }} -
                {{ fomartDate(item.endDate) }}
              </p>
              <p class="people-course">
                <img src="/img/icons8-users-30.png" alt="" />
                <span>{{ item.totalStudent }}</span>
              </p>
              <p class="discription-course">
                {{ item.description }}
              </p>
            </div>
          </router-link>
        </div>
      </div> -->
        <div class="row">
          <div class="col-3 pt-4" v-for="item in getAll" :key="item.id">
            <router-link :to="`/detail-course/${item.id}`">
              <div class="card" style="width: 18rem; height: 360px">
                <img
                  :src="item.image"
                  class="card-img-top"
                  alt="..."
                  height="180"
                />
                <div class="card-body">
                  <h5 class="card-title">{{ item.name }}</h5>
                  <p class="card-text">
                    {{ item.description }}
                  </p>
                  <p style="font-weight: 600" class="card-text">
                    Thời gian: {{ item.estimatedStartTime }}
                  </p>
                  <span style="color: red; font-weight: 700">{{
                    formatPrice(item.price)
                  }}</span>
                </div>
              </div>
            </router-link>
          </div>
        </div>
      </div>

      <!-- Modal add course -->
      <div
        class="modal fade"
        id="exampleModal"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
        v-show="showModal"
      >
        <div class="modal-dialog modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <p style="font-size: 25px; font-weight: bold; padding: 15px">
                <img src="/img/pen2.png" alt="" width="40px" /> Thêm mới khóa
                học
              </p>
            </div>
            <div class="modal-body">
              <div class="container">
                <div class="row">
                  <div class="col-6">
                    <p style="font-weight: bold; margin-top: 20px">
                      Tên khóa học <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Tên khóa học"
                      v-model="addCourse.name"
                    />
                    <div class="checkError">{{ checkError.name }}</div>

                    <div class="checkError">{{ checkError.description }}</div>
                    <p style="font-weight: bold; margin-top: 20px">
                      Giá khóa học <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Giá khóa học"
                      v-model="addCourse.price"
                    />
                    <p style="font-weight: bold; margin-top: 20px">
                      Ảnh khóa học <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Tên khóa học"
                      v-model="addCourse.image"
                    />
                  </div>
                  <div class="col-6">
                    <!-- ------------------------------------- -->
                    <!-- <p style="font-weight: bold; margin-top: 20px">
                    Ngày bắt đầu <span style="color: red">*</span>
                  </p>
                  <input
                    type="date"
                    class="form-control"
                    id="exampleFormControlInput1"
                    placeholder="Họ và tên"
                    v-model="addCourse.startDate"
                  />
                  <div class="checkError">{{ checkError.startDate }}</div>

           
                  <p style="font-weight: bold; margin-top: 20px">
                    Ngày kết thúc <span style="color: red">*</span>
                  </p>
                  <input
                    type="date"
                    class="form-control"
                    id="exampleFormControlInput1"
                    placeholder="Họ và tên"
                    v-model="addCourse.endDate"
                  />
                  <div class="checkError">{{ checkError.endDate }}</div>

                  <p style="font-weight: bold; margin-top: 20px">
                    Các môn học <span style="color: red">*</span>
                  </p>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleFormControlInput1"
                    placeholder="Nhập theo định dạng (toán,văn,anh ...)"
                    v-model="addCourse.subjectName"
                    @input="handleSubjectInputChange"
                  />
                  <div class="checkError">{{ checkError.subjectName }}</div> -->

                    <!-- ------------------------------------- -->
                    <p style="font-weight: bold; margin-top: 20px">
                      Thời gian dự kiến hoàn thành
                      <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Thời gian dự kiến"
                      v-model="addCourse.estimatedStartTime"
                    />
                    <!-- ------------------------------------- -->
                    <p style="font-weight: bold; margin-top: 20px">
                      Mô tả <span style="color: red">*</span>
                    </p>
                    <textarea
                      class="form-control"
                      id="exampleFormControlTextarea1"
                      rows="3"
                      v-model="addCourse.description"
                    ></textarea>
                  </div>
                </div>
              </div>
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
                @click="handleAddCourse()"
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
import dayjs from "dayjs";
import CourseApi from "../../api/CourseApi";
import Course from "../../types/Course";
import { ref, watchEffect } from "vue";
import Stduent from "../../types/Student";
import { log } from "console";
import Menu from "../../layout/Menu.vue";

const getAll = ref<Course[]>([]);
const showModal = ref(false);
const getAllStudent = ref<Stduent[]>([]);
const selectIdStudent = ref([]);
const dataSubjectName = ref([]);

const formatDateToDateTime = (date: Date) => {
  return dayjs(date).format("YYYY-MM-DDTHH:mm:ss");
};
const fomartDate = (date: Date) => {
  return dayjs(date).format("DD/MM/YYYY");
};
const formatPrice = (price: any) => {
  let formattedPrice = (price / 1)
    .toFixed(0)
    .replace(/\B(?=(\d{3})+(?!\d))/g, ".");
  return `${formattedPrice} VND`;
};
const addCourse = ref<Course>({
  name: "",
  description: "",
  startDate: new Date(),
  endDate: new Date(),
  totalStudent: 0,
  price: 0,
  image: "",
  estimatedStartTime: "",
  subjectName: dataSubjectName.value,
});

const checkError = ref({
  name: "",
  description: "",
  startDate: "",
  endDate: "",
  totalStudent: "",
  subjectName: "",
});

const handleSubjectInputChange = () => {
  const subjectsInput = addCourse.value.subjectName.split(",");

  dataSubjectName.value = subjectsInput; // Cập nhật giá trị của biến subjectNames
  addCourse.value.subjectName = dataSubjectName.value; // Cập nhật giá trị của addCourse
};
addCourse.value.subjectName = dataSubjectName.value;

const handleCheckBox = (studentId) => {
  if (selectIdStudent.value.includes(studentId)) {
    selectIdStudent.value = selectIdStudent.value.filter(
      (id) => id !== studentId
    );
  } else {
    selectIdStudent.value.push(studentId);
  }

  console.log(selectIdStudent.value);
};

const handleAddCourse = () => {
  addCourse.value.startDate = formatDateToDateTime(addCourse.value.startDate);
  addCourse.value.endDate = formatDateToDateTime(addCourse.value.endDate);
  addCourse.value.studentId = selectIdStudent.value;
  CourseApi.addCourse(addCourse.value).then((response) => {
    fetchData();
    showModal.value = false;
  });
};

console.log(addCourse.value, "get account");

const fetchDataStudent = () => {
  CourseApi.getAllStudent().then((response) => {
    getAllStudent.value = response.data;
  });
};

const fetchData = () => {
  CourseApi.getAll().then((response) => {
    getAll.value = response.data;
    console.log(response.data);
  });
};

watchEffect(() => {
  fetchData();
  fetchDataStudent();
});
</script>
<style scoped>
a {
  text-decoration: none;
}
.courses {
  width: 90%;
  height: 200px;
  /* background-color: #ffae33; */
  border-radius: 20px;
  margin-bottom: 30px;
  /* background: linear-gradient(135deg, #ffae33 50%, #ffff00 50%) */
  background: linear-gradient(to right, #ffa726, #ff7f00);
}
.title-course {
  font-size: 25px;
  font-weight: bold;
  color: white;
  text-align: center;
}
.time-course {
  color: gray;
  text-align: center;
}
.people-course {
  text-align: center;
}
.people-course span {
  font-size: 20px;
  color: white;
  margin-left: 20px;
  padding-top: 20px;
}
.discription-course {
  text-align: center;
  color: white;
  padding: 5px;
}
.checkError {
  color: red;
  font-size: 14px;
  font-weight: 700;
}
.modal-backdrop.show {
  opacity: none !important;
}
</style>

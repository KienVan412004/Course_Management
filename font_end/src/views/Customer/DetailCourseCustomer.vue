<template>
  <MenuCustomer>
    <div>
      <div>
        <img
          src="/img/background_detail_course.jpg"
          alt=""
          style="width: 100%; height: 500px"
        />
      </div>
      <div class="container">
        <div
          class="row"
          style="
            width: 100%;
            height: 500px;
            background-color: white;
            border-radius: 20px;
            margin-top: 50px;
            padding: 20px;
          "
        >
          <div class="col-6">
            <img :src="detailCourse.image" alt="" style="width: 400px" />
            <p class="title-detail-course">{{ detailCourse.name }}</p>
            <p class="time-price">
              Thời gian: {{ detailCourse.estimatedStartTime }}
            </p>
            <p class="time-price">Giá tiền: {{ detailCourse.price }}</p>
          </div>
          <div class="col-6">
            <div class="modal-body">
              <div class="container">
                <div class="row">
                  <div class="col-6">
                    <p style="font-weight: bold; margin-top: 20px">
                      Họ và tên <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Họ và tên"
                      v-model="registerCourse.fullName"
                    />
                    <!-- ------------------------------------- -->
                    <p style="font-weight: bold; margin-top: 20px">
                      Số điện thoại <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Số điện thoại"
                      v-model="registerCourse.phoneNumber"
                    />
                    <!-- ------------------------------------- -->
                    <p style="font-weight: bold; margin-top: 20px">
                      Email <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Email"
                      v-model="registerCourse.email"
                    />
                    <!-- ------------------------------------- -->
                  </div>

                  <div class="col-6">
                    <p style="font-weight: bold; margin-top: 20px">
                      Địa chỉ <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Địa chỉ"
                      v-model="registerCourse.address"
                    />
                    <!-- ------------------------------------- -->
                    <p style="font-weight: bold; margin-top: 20px">
                      Ngày sinh <span style="color: red">*</span>
                    </p>
                    <input
                      type="date"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Họ và tên"
                      v-model="registerCourse.dateOfBirth"
                    />
                    <button
                      type="button"
                      class="btn btn-primary"
                      style="
                        width: 130px;
                        border-radius: 10px;
                        background-color: #ffa726;
                        border: none;
                        color: black;
                        float: right;
                        color: white;
                        font-weight: bold;
                        margin-top: 150px;
                      "
                      @click="handleRegisterCourse"
                    >
                      Đăng kí ngay
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div>
          <p
            style="
              text-align: center;
              font-size: 24px;
              font-weight: 700;
              color: #ae1a20;
              margin-top: 20px;
            "
          >
            DANH SÁCH CÁC MÔN HỌC VÀ LỘ TRÌNH CHI TIẾT
          </p>

          <div class="row">
            <div class="col-8">
              <div v-for="(item, index) in getSubjectByCourse" :key="item.id">
                <Accordion style="text-decoration: none" :activeIndex="1">
                  <AccordionTab
                    :header="`Môn học: ${index + 1} ${item.subjectName}`"
                  >
                    <p v-html="item.description" class="m-0"></p>
                  </AccordionTab>
                </Accordion>
              </div>
            </div>
            <div class="col-4">
              <img
                src="/img/lo-trinh-hoc-lap-trinh.png"
                alt=""
                style="width: 100%"
              />
            </div>
          </div>
        </div>
      </div>
      <div class="footer"></div>
    </div>
  </MenuCustomer>
</template>
<script setup lang="ts">
import Vue, { ref, watchEffect } from "vue";
import MenuCustomer from "../Customer/MenuCustomer.vue";
import type Course from "@/types/Course";
import { useRoute } from "vue-router";
import HomeApi from "@/api/HomeApi";
import Subject from "../../types/Subject";
import Studuent from "../../types/Student";
import { toast } from "vue3-toastify";
import dayjs from "dayjs";
import Accordion from "primevue/accordion";
import AccordionTab from "primevue/accordiontab";

const detailCourse = ref<Course>();
const router = useRoute();
const getSubjectByCourse = ref<Subject[]>([]);
const registerCourse = ref<Studuent>({
  id: "",
  fullName: "",
  dateOfBirth: new Date(),
  phoneNumber: "",
  address: "",
  email: "",
  code: "",
  courseId: router.params.id,
});

const clearData = () => {
  registerCourse.value.fullName = "";
  registerCourse.value.phoneNumber = "";
  registerCourse.value.address = "";
  registerCourse.value.email = "";
};

const handleRegisterCourse = () => {
  registerCourse.value.dateOfBirth = dayjs(
    registerCourse.value.dateOfBirth
  ).format("YYYY-MM-DDTHH:mm:ss");
  HomeApi.registerCourse(registerCourse.value)
    .then((response) => {
      clearData();
      toast.success("Đăng kí khóa học thành công", {
        position: toast.POSITION.TOP_RIGHT,
      });
    })
    .catch((error) => {
      toast.error("Đăng kí khóa học thất bại", {
        position: toast.POSITION.TOP_RIGHT,
      });
    });
};

const handleGetSubjectByCourse = (courseId: string) => {
  HomeApi.getSubjectByCourseId(courseId).then((response) => {
    getSubjectByCourse.value = response.data;
  });
};

const getOne = (id: string) => {
  HomeApi.detailCourse(id).then((response) => {
    detailCourse.value = response.data;
  });
};

watchEffect(() => {
  getOne(router.params.id);
  handleGetSubjectByCourse(router.params.id);
});
</script>
<style>
.title-detail-course {
  font-size: 25px;
  font-weight: 700;
}
.time-price {
  font-weight: 600;
}
.footer {
  width: 100%;
  height: 400px;
  background-color: #ae1a20;
  margin-top: 50px;
}
.p-accordion-header a {
  text-decoration: none !important;
  color: black;
}
.p-accordion-header-link {
  background-color: rgb(218, 217, 217) !important;
  border-bottom: 1px solid black;
}
</style>

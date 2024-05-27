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
            <table class="table" style="margin-top: 50px">
              <thead style="background-color: gray">
                <tr>
                  <th scope="col">Stt</th>
                  <th scope="col">Mã môn</th>
                  <th scope="col">Tên môn</th>
                  <th scope="col">Ngày bắt đầu</th>
                  <th>Ngày kết thúc</th>
                  <th>Trạng thái</th>
                  <th>Hành động</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(item, index) in getSubjectByClass" :key="item.id">
                  <th>
                    {{ index + 1 }}
                  </th>
                  <td>{{ item.subjectCode }}</td>
                  <td>{{ item.subjectName }}</td>
                  <td>{{ formatDate(item.startDate) }}</td>
                  <td>{{ formatDate(item.endDate) }}</td>
                  <td>
                    <span
                      class="badge text-bg-secondary"
                      v-if="item.status === 0"
                      >Chưa học</span
                    >
                    <span
                      class="badge text-bg-primary"
                      v-else-if="item.status === 1"
                      >Đang học</span
                    >
                    <span
                      v-else-if="item.status === 2"
                      class="badge text-bg-success"
                      >Đã học</span
                    >
                  </td>

                  <td>
                    <!-- <button
                      v-if="
                        (index === 0 ||
                          (index !== 0 &&
                            (getSubjectByClass[index - 1].status === 1 ||
                              getSubjectByClass[index - 1].status === 2))) &&
                        item.status !== 2
                      "
                      type="button"
                      class="btn btn-success"
                      style="
                        display: flex;
                        align-items: center;
                        justify-content: center;
                      "
                      @click="handleChangeStatus(item.id)"
                    ></button> -->
                    <div
                      v-if="
                        (index === 0 ||
                          (index !== 0 &&
                            (getSubjectByClass[index - 1].status === 1 ||
                              getSubjectByClass[index - 1].status === 2))) &&
                        item.status !== 2
                      "
                      @click="handleChangeStatus(item.id)"
                      style="cursor: pointer"
                    >
                      <span
                        v-if="item.status === 0"
                        class="badge rounded-pill text-bg-info"
                        >Mở lớp</span
                      >
                      <span v-else class="badge rounded-pill text-bg-success"
                        >Đóng lớp</span
                      >
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import ScoreApi from "@/api/ScoreApi";
import type Subject from "@/types/Subject";
import dayjs from "dayjs";
import Vue, { ref, watchEffect } from "vue";
import { useRoute } from "vue-router";
import Menu from "../../layout/Menu.vue";
import Confirm from "@/components/Confirm";
import { toast } from "vue3-toastify";
const router = useRoute();
const getSubjectByClass = ref<Subject[]>([]);
const changeStatusSubject = ref<Subject[]>([]);

const formatDate = (date: Date) => {
  return dayjs(date).format("DD-MM-YYYY");
};

const handleChangeStatus = (id: string) => {
  const title = "Bạn có muốn mở hoặc đóng lớp không ?";
  const test = "";
  Confirm(title, test).then((result) => {
    if (result.isConfirmed) {
      ScoreApi.changeStatus(id, router.params.id).then(() => {
        handleGetSubjectByClass(router.params.id);
        toast.success("Mở hoặc đóng lớp thành công", {
          position: toast.POSITION.TOP_RIGHT,
        });
      });
    }
  });
};

const handleGetSubjectByClass = (id: string) => {
  ScoreApi.getSubjectByClass(id).then((response) => {
    getSubjectByClass.value = response.data;
  });
};
watchEffect(() => {
  handleGetSubjectByClass(router.params.id);
});
</script>

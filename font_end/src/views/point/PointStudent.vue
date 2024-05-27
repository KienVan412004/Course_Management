<template>
  <Menu>
    <div class="container pt-4">
      <div class="container" style="padding-top: 20px">
        <div
          style="height: 500px; background-color: white; border-radius: 20px"
        >
          <p style="font-size: 25px; font-weight: bold; padding: 15px">
            <img src="/img/pen2.png" alt="" width="50px" /> Bảng điểm
          </p>
          <hr />
          <div class="container">
            <div>
              <table class="table" style="margin-top: 80px">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Môn học</th>
                    <th>Mã Môn</th>
                    <th scope="col">Điểm</th>
                    <th>Trạng thái</th>
                  </tr>
                </thead>
                <tbody>
                  <tr
                    v-for="(item, index) in getPointStudentById"
                    :key="item.id"
                  >
                    <th>{{ index + 1 }}</th>
                    <td>{{ item.subjectName }}</td>
                    <td>{{ item.subjectCode }}</td>
                    <td>{{ item.pointStudent }}</td>
                    <td>
                      <span
                        v-if="item.status == 0"
                        class="badge rounded-pill text-bg-secondary"
                        >Chưa học</span
                      >
                      <span
                        v-else-if="item.status == 1"
                        class="badge rounded-pill text-bg-primary"
                        >Đang học</span
                      >

                      <span v-else class="badge rounded-pill text-bg-success"
                        >Đã học</span
                      >
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </Menu>
</template>
<script setup lang="ts">
import Vue, { ref, watchEffect } from "vue";
import Menu from "@/layout/Menu.vue";
import type Point from "@/types/Point";
import ScoreApi from "../../api/ScoreApi";

const getPointStudentById = ref<Point[]>([]);

const handleGetPointStudent = (id: string) => {
  ScoreApi.getPointStudentById(id).then((response) => {
    getPointStudentById.value = response.data;
  });
};

watchEffect(() => {
  handleGetPointStudent("00577c7c-6f74-4107-8a4f-8be87c93677b");
});
</script>

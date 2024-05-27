<template>
  <Menu>
    <div class="container" style="padding-top: 40px">
      <p style="font-size: 25px; font-weight: bold; padding: 15px">
        <img src="/img/pen2.png" alt="" width="50px" /> Quản lý điểm
      </p>
      <div class="content-point">
        <div class="content-class">
          <div class="row">
            <div class="col-3" v-for="item in getClassByTeacher" :key="item.id">
              <router-link
                class="linkClass"
                :to="`/detail-points-subject/${item.id}`"
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
                    Lớp học:{{ item.className }} <br />
                    Mã Lớp:{{ item.classCode }}
                  </span>
                </div>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </Menu>
</template>
<script setup lang="ts">
import ScoreApi from "@/api/ScoreApi";
import type Classes from "@/types/Classes";
import type Studuent from "@/types/Student";
import Vue, { ref, watchEffect } from "vue";
import { useRoute } from "vue-router";
import Menu from "../layout/Menu.vue";

const getClassByTeacher = ref<Classes[]>([]);
const getStudentInClass = ref<Studuent[]>([]);

const handleGetClassByTeacher = (id: string) => {
  ScoreApi.getClassByStudent(id).then((response) => {
    getClassByTeacher.value = response.data;
  });
};

watchEffect(() => {
  handleGetClassByTeacher("06d47cf4-ed80-490d-a4c4-95bd8d64f2eb");
});
</script>
<style scoped>
.content-point {
  height: 500px;
  width: 100%;
  background-color: white;
  border-radius: 30px;
}
.student-course {
  height: 105px;
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
.linkClass {
  text-decoration: none;
  color: black;
}
.content-class {
  padding: 20px;
}
</style>

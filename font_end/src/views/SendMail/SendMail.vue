<template>
  <Menu>
    <div class="container pt-5">
      <p style="font-size: 25px; font-weight: bold">
        <img src="/img/pen2.png" alt="" width="50px" /> Quản lý template email
      </p>
      <img
        src="/img/plus.png"
        data-bs-toggle="modal"
        data-bs-target="#exampleModal"
        alt=""
        width="30px"
        style="float: right; margin-right: 30px; margin-top: 30px"
      />
      <div class="mail">
        <div class="row">
          <div class="col-4 mb-4" v-for="item in getAll" :key="item.id">
            <div
              class="template-mail"
              data-bs-toggle="modal"
              data-bs-target="#staticBackdrop"
              @click="handleGetOne(item.id)"
            >
              <div class="row">
                <div class="col-3">
                  <img src="/img/mail3.png" alt="" width="160%" />
                </div>
                <div class="col-9">
                  <span class="title-mail">{{ item.type }}</span> <br />
                  <span>
                    <img src="/img/icons8-success-24.png" width="6%" alt="" />
                    <span
                      style="font-size: 14px; color: green; font-weight: 600"
                    >
                      Đã có trên máy</span
                    ></span
                  >
                </div>
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
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <div class="modal-header">
                <p style="font-size: 25px; font-weight: bold; padding: 15px">
                  <img src="/img/pen2.png" alt="" width="30px" /> Thêm mới môn
                  học
                </p>
              </div>
              <div class="modal-body">
                <div class="row">
                  <div class="col-6">
                    <p style="font-weight: bold; margin-top: 20px">
                      Loại email: <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Loại email"
                      v-model="addMail.type"
                    />
                  </div>
                  <div class="col-6">
                    <p style="font-weight: bold; margin-top: 20px">
                      Tiêu đề email: <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Tiêu đề"
                      v-model="addMail.title"
                    />
                  </div>
                </div>
                <p style="font-weight: bold; margin-top: 20px">
                  Nội dung email: <span style="color: red">*</span>
                </p>

                <Editor v-model="addMail.content" editorStyle="height: 320px" />
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
                  @click="handleAddMail"
                >
                  Xác nhận
                </button>
              </div>
            </div>
          </div>
        </div>

        <!-- Modal -->
        <div
          class="modal fade"
          id="staticBackdrop"
          data-bs-backdrop="static"
          data-bs-keyboard="false"
          tabindex="-1"
          aria-labelledby="staticBackdropLabel"
          aria-hidden="true"
        >
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">
                  Modal title
                </h1>
              </div>
              <div class="modal-body">
                <div class="row">
                  <div class="col-6">
                    <p style="font-weight: bold; margin-top: 20px">
                      Loại email: <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Loại email"
                      disabled
                      v-model="updateMail.type"
                    />
                  </div>
                  <div class="col-6">
                    <p style="font-weight: bold; margin-top: 20px">
                      Tiêu đề email: <span style="color: red">*</span>
                    </p>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Tiêu đề"
                      v-model="updateMail.title"
                    />
                  </div>
                </div>
                <p style="font-weight: bold; margin-top: 20px">
                  Nội dung email: <span style="color: red">*</span>
                </p>

                <Editor
                  v-model="updateMail.content"
                  editorStyle="height: 320px"
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
                  @click="handleUpdateMail(getOne.id)"
                >
                  Xác nhận
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </Menu>
</template>
<script setup lang="ts">
import Vue, { ref, watchEffect } from "vue";
import Menu from "../../layout/Menu.vue";
import Editor from "primevue/editor";
import SendMail from "../../types/SendMail";
import SendMailApi from "../../api/SendMailApi";
import { toast } from "vue3-toastify";
import Confirm from "@/components/Confirm";

const addMail = ref<SendMail>({
  id: "",
  title: "",
  content: "",
  type: "",
});
const updateMail = ref<SendMail>({
  id: "",
  title: "",
  content: "",
  type: "",
});
const getAll = ref<SendMail[]>([]);
const getOne = ref<SendMail>();

const handleUpdateMail = (id: string) => {
  const title = "Bạn có muốn update không";
  const text = "";
  Confirm(title, text).then((result) => {
    if (result.isConfirmed) {
      SendMailApi.updateMail(updateMail.value, id)
        .then((response) => {
          toast.success("Update thành công", {
            position: toast.POSITION.TOP_RIGHT,
          });
        })
        .catch(() => {
          toast.error("Update thất bại", {
            position: toast.POSITION.TOP_RIGHT,
          });
        });
    }
  });
};

const fetchData = () => {
  SendMailApi.getAll().then((response) => {
    getAll.value = response.data;
  });
};
const handleGetOne = (id: string) => {
  SendMailApi.getOne(id).then((response) => {
    getOne.value = response.data;
    updateMail.value = { ...response.data };
  });
};
const handleAddMail = () => {
  SendMailApi.addMail(addMail.value).then((response) => {
    fetchData();
    toast.success("Thêm template mail thành công", {
      position: toast.POSITION.TOP_RIGHT,
    });
    console.log(addMail.value, "dữ liệu truyền về");
  });
};
watchEffect(() => {
  fetchData();
  handleGetOne(getOne.id);
});
</script>
<style scoped>
.mail {
  height: 500px;
  width: 100%;
  background-color: white;
  border-radius: 20px;
  padding-top: 150px;
  padding-left: 30px;
  padding-right: 30px;
}
.template-mail {
  width: 100%;
  height: 90px;
  border: 2px solid rgb(50, 169, 255);
  /* background-color: rgb(255, 71, 71); */
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.title-mail {
  font-weight: 700;
  margin-top: 20px;
}
</style>

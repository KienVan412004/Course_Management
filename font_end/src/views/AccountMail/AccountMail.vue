<template>
  <Menu>
    <div class="container" style="padding-top: 40px">
      <div style="height: 700px; background-color: white; border-radius: 20px">
        <p style="font-size: 25px; font-weight: bold; padding: 15px">
          <img src="/img/pen2.png" alt="" width="50px" /> Quản lý tài khoản gửi
          mail
        </p>
        <hr />
        <div class="container">
          <div class="row">
            <div class="col-6"></div>
            <div class="col-2"></div>
            <div class="col-2"></div>
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
                  <th scope="col">#</th>
                  <th scope="col">UserName</th>
                  <th scope="col">Password</th>
                  <th scope="col">Host</th>
                  <th scope="col">Port</th>
                  <th scope="col">Status</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(item, index) in getAll" :key="item.id">
                  <th>{{ index + 1 }}</th>
                  <td>{{ item.username }}</td>
                  <td>{{ item.password }}</td>
                  <td>{{ item.host }}</td>
                  <td>{{ item.port }}</td>
                  <td>
                    <span v-if="item.status == 1" class="badge text-bg-primary"
                      >Đang sử dụng</span
                    >
                    <span v-else class="badge text-bg-secondary"
                      >Không sử dụng</span
                    >
                  </td>
                  <td>
                    <span
                      v-if="item.status != 1"
                      style="cursor: pointer"
                      @click="handleUpdateStatus(item.id)"
                      class="badge rounded-pill text-bg-success"
                      >Sử dụng</span
                    >
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <!-- Modal add -->
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
            <h1 class="modal-title fs-5" id="exampleModalLabel">
              Thêm tài khoản gửi mail
            </h1>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="col-6">
                <p style="font-weight: bold; margin-top: 20px">
                  UserName: <span style="color: red">*</span>
                </p>
                <input
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  placeholder="UserName"
                  v-model="addAccountMail.username"
                />
              </div>
              <div class="col-6">
                <p style="font-weight: bold; margin-top: 20px">
                  Password: <span style="color: red">*</span>
                </p>
                <input
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  placeholder="Password"
                  v-model="addAccountMail.password"
                />
              </div>

              <div class="col-6">
                <p style="font-weight: bold; margin-top: 20px">
                  Host: <span style="color: red">*</span>
                </p>
                <input
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  placeholder="Host"
                  v-model="addAccountMail.host"
                />
              </div>
              <div class="col-6">
                <p style="font-weight: bold; margin-top: 20px">
                  Port: <span style="color: red">*</span>
                </p>
                <input
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  placeholder="Post"
                  v-model="addAccountMail.port"
                />
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
              @click="handleAddAccountMail()"
            >
              Xác nhận
            </button>
          </div>
        </div>
      </div>
    </div>
  </Menu>
</template>
<script setup lang="ts">
import Vue, { ref, watchEffect } from "vue";
import Menu from "../../layout/Menu.vue";
import AccountMail from "../../types/AccountMail";
import AccountMailApi from "../../api/AccountMailApi";
import { toast } from "vue3-toastify";

const getAll = ref<AccountMail[]>([]);

const addAccountMail = ref<AccountMail>({
  id: "",
  host: "",
  port: 0,
  username: "",
  password: "",
  status: 0,
});
const fetchData = () => {
  AccountMailApi.getAll().then((response) => {
    getAll.value = response.data;
  });
};
const handleAddAccountMail = () => {
  AccountMailApi.addAccountMail(addAccountMail.value)
    .then(() => {
      fetchData();
      toast.success("Thêm tài khoản thành công", {
        position: toast.POSITION.TOP_RIGHT,
      });
    })
    .catch(() => {
      toast.error("Thêm tài khoản thất bại", {
        position: toast.POSITION.TOP_RIGHT,
      });
    });
};
const handleUpdateStatus = (id: string) => {
  AccountMailApi.updateStatusMail(id)
    .then((response) => {
      fetchData();
      toast.success("Đổi tài khoản thành công", {
        position: toast.POSITION.TOP_RIGHT,
      });
    })
    .catch(() => {
      toast.error("Đổi tài khoản thất bại", {
        position: toast.POSITION.TOP_RIGHT,
      });
    });
};

watchEffect(() => {
  fetchData();
});
</script>

<template>
  <Menu>
    <div class="account">
      <div class="container" style="padding-top: 40px">
        <div
          style="height: 700px; background-color: white; border-radius: 20px"
        >
          <p style="font-size: 25px; font-weight: bold; padding: 15px">
            <img src="/img/pen2.png" alt="" width="50px" /> Quản lý tài khoản
          </p>
          <hr />
          <div class="container">
            <div class="row">
              <div class="col-6">
                <input
                  type="text"
                  id="inputPassword5"
                  class="form-control"
                  aria-describedby="passwordHelpBlock"
                  style="
                    width: 70%;

                    border-radius: 20px;
                    height: 40px;
                  "
                  placeholder="Tìm kiếm ..."
                  v-model="getPage.fullName"
                />
              </div>
              <div class="col-2">
                <input
                  type="date"
                  id="inputPassword5"
                  class="form-control"
                  aria-describedby="passwordHelpBlock"
                  style="width: 100%; border-radius: 20px; height: 40px"
                  placeholder="Tìm kiếm ..."
                />
              </div>
              <div class="col-2">
                <input
                  type="date"
                  id="inputPassword5"
                  class="form-control"
                  aria-describedby="passwordHelpBlock"
                  style="width: 100%; border-radius: 20px; height: 40px"
                  placeholder="Tìm kiếm ..."
                />
              </div>
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
                    <th scope="col">Stt</th>
                    <th scope="col">Full Name</th>
                    <th scope="col">Email</th>

                    <th scope="col">Phone Number</th>
                    <th scope="col">Role</th>
                    <th scope="col">Gender</th>
                    <th scope="col">Date Of Birth</th>
                    <th>Status</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="(item, index) in getAllAccount" :key="item.id">
                    <th>{{ index + 1 }}</th>
                    <th>{{ item.fullName }}</th>
                    <th>{{ item.email }}</th>

                    <th>{{ item.phoneNumber }}</th>
                    <th>{{ item.role }}</th>
                    <th>{{ item.gender }}</th>
                    <th>
                      {{ formatDate(item.dateOfBirth) }}
                    </th>
                    <th>{{ item.status }}</th>
                    <th>
                      <button
                        type="button"
                        class="btn btn-primary"
                        data-bs-toggle="modal"
                        data-bs-target="#staticBackdrop"
                        style="
                          width: 50px;
                          height: 45px;
                          border-radius: 15px;
                          background-color: #ffd75e;
                          border: none;
                        "
                        @click="getOne(item.id)"
                      >
                        <img src="/img/icons8-eye-24.png" alt="" />
                      </button>
                    </th>
                  </tr>
                </tbody>
              </table>
            </div>
            <!-- phan trang -->

            <nav aria-label="Page navigation example">
              <ul class="pagination">
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                </li>
                <li
                  class="page-item"
                  v-for="(item, index) in totalPage"
                  :key="index"
                >
                  <a
                    class="page-link"
                    href="#"
                    @click="changePage(index + 1)"
                    >{{ index + 1 }}</a
                  >
                </li>
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                  </a>
                </li>
              </ul>
            </nav>
          </div>
        </div>

        <!-- Modal -->
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
                  <img src="/img/pen2.png" alt="" width="40px" /> Thêm mới tài
                  khoản
                </p>
              </div>
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
                        name="fullName"
                        placeholder="Họ và tên"
                        v-model="addAccount.fullName"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Số điện thoại <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        placeholder="Họ và tên"
                        name="phoneNumber"
                        v-model="addAccount.phoneNumber"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Email <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        placeholder="email"
                        name="email"
                        v-model="addAccount.email"
                      />
                      <!-- ------------------------------------- -->
                    </div>

                    <div class="col-6">
                      <p style="font-weight: bold; margin-top: 20px">
                        Mật khẩu <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        placeholder="password"
                        name="password"
                        v-model="addAccount.password"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Ngày sinh <span style="color: red">*</span>
                      </p>
                      <input
                        type="date"
                        class="form-control"
                        name="dateOfBirth"
                        v-model="addAccount.dateOfBirth"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Quyền <span style="color: red">*</span>
                      </p>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          id="inlineRadio1"
                          name="role"
                          value="0"
                          v-model="addAccount.role"
                        />
                        <label class="form-check-label" for="inlineRadio1"
                          >Quản lý</label
                        >
                      </div>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          id="inlineRadio2"
                          name="role"
                          value="1"
                          v-model="addAccount.role"
                        />
                        <label class="form-check-label" for="inlineRadio2"
                          >Giáo viên</label
                        >
                      </div>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          id="inlineRadio2"
                          name="role"
                          value="2"
                          v-model="addAccount.role"
                        />
                        <label class="form-check-label" for="inlineRadio2"
                          >Sinh viên</label
                        >
                      </div>
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Giới tính <span style="color: red">*</span>
                      </p>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          id="inlineRadio1"
                          name="gender"
                          value="0"
                          v-model="addAccount.gender"
                        />
                        <label class="form-check-label" for="inlineRadio1"
                          >Nam</label
                        >
                      </div>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          id="inlineRadio2"
                          name="gender"
                          value="1"
                          v-model="addAccount.gender"
                        />
                        <label class="form-check-label" for="inlineRadio2"
                          >Nữ</label
                        >
                      </div>
                      <!-- ------------------------------------- -->
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
                  @click="
                    {
                      addNewAccount();
                    }
                  "
                >
                  Xác nhận
                </button>
              </div>
            </div>
          </div>
        </div>

        <!-- Modal detail-->
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
                <p style="font-size: 25px; font-weight: bold; padding: 15px">
                  <img src="/img/pen2.png" alt="" width="40px" /> Thêm mới tài
                  khoản
                </p>
              </div>
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
                        name="fullName"
                        placeholder="Họ và tên"
                        v-model="updateAccount.fullName"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Số điện thoại <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        placeholder="Họ và tên"
                        name="phoneNumber"
                        v-model="updateAccount.phoneNumber"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Email <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        placeholder="email"
                        name="email"
                        v-model="updateAccount.email"
                      />
                      <!-- ------------------------------------- -->
                    </div>

                    <div class="col-6">
                      <p style="font-weight: bold; margin-top: 20px">
                        Mật khẩu <span style="color: red">*</span>
                      </p>
                      <input
                        type="text"
                        class="form-control"
                        placeholder="password"
                        name="password"
                        v-model="updateAccount.password"
                      />
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Ngày sinh <span style="color: red">*</span>
                      </p>
                      <input
                        type="date"
                        class="form-control"
                        name="dateOfBirth"
                        fomart="dd/mm/yyyy"
                        v-model="updateAccount.dateOfBirth"
                      />

                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Quyền <span style="color: red">*</span>
                      </p>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          id="inlineRadio1"
                          name="role"
                          value="0"
                          v-model="updateAccount.role"
                        />
                        <label class="form-check-label" for="inlineRadio1"
                          >Quản lý</label
                        >
                      </div>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          id="inlineRadio2"
                          name="role"
                          value="1"
                          v-model="updateAccount.role"
                        />
                        <label class="form-check-label" for="inlineRadio2"
                          >Giáo viên</label
                        >
                      </div>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          id="inlineRadio2"
                          name="role"
                          value="2"
                          v-model="updateAccount.role"
                        />
                        <label class="form-check-label" for="inlineRadio2"
                          >Sinh viên</label
                        >
                      </div>
                      <!-- ------------------------------------- -->
                      <p style="font-weight: bold; margin-top: 20px">
                        Giới tính <span style="color: red">*</span>
                      </p>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          id="inlineRadio1"
                          name="gender"
                          value="0"
                          v-model="updateAccount.gender"
                        />
                        <label class="form-check-label" for="inlineRadio1"
                          >Nam</label
                        >
                      </div>
                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          id="inlineRadio2"
                          name="gender"
                          value="1"
                          v-model="updateAccount.gender"
                        />
                        <label class="form-check-label" for="inlineRadio2"
                          >Nữ</label
                        >
                      </div>
                      <!-- ------------------------------------- -->
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
                  @click="handleUpdateAccount(getOneAccount.id)"
                  style="
                    width: 130px;
                    border-radius: 10px;
                    background-color: #ffa726;
                    border: none;
                    color: black;
                  "
                >
                  Update
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
import { ref, watchEffect } from "vue";
import Account from "../types/Account";
import AccountApi from "../api/AccountApi";
import dayjs from "dayjs";
import XLSX from "xlsx";
import Menu from "../layout/Menu.vue";

const getAllAccount = ref<Account[]>([]);

const getPage = ref({ fullName: "", page: 1, size: 5 });

const totalPage = ref([0]);

const currentPage = ref([1]);

const getOneAccount = ref<Account[]>([]);

const addAccount = ref<Account>({
  fullName: "",
  email: "",
  password: "",
  phoneNumber: "",
  status: 1,
  role: 1,
  gender: 1,
  dateOfBirth: new Date(),
});

const updateAccount = ref<Account>({
  fullName: "",
  email: "",
  password: "",
  phoneNumber: "",
  status: 1,
  role: 1,
  gender: 1,
  dateOfBirth: new Date(),
});

const changePage = (pageNumber: number) => {
  getPage.value = pageNumber;
  getPageAccount(getPage.value);
};

const formatDate = (date: Date) => {
  return dayjs(date).format("DD/MM/YYYY");
};

const getPageAccount = (page: any) => {
  AccountApi.getPageAccount(page).then((response) => {
    getPage.value = response.data.content;
    totalPage.value = response.data.totalPages;
    console.log(response.data.content, "filter");
    console.log(response.data.totalPages, "total");
    console.log(getPage.value.fullName, "full name");
  });
};
console.log(getPage.value, "getpage");

console.log(totalPage.value, "total page");

const handleUpdateAccount = (accountId: String) => {
  AccountApi.update(updateAccount.value, accountId).then((response) => {
    fetchData();
  });
};

const getOne = (accountId: String) => {
  AccountApi.getOne(accountId).then((response) => {
    getOneAccount.value = response.data;

    updateAccount.value = { ...response.data };
  });
};

const addNewAccount = () => {
  AccountApi.addAccount(addAccount.value).then((response) => {
    fetchData();
  });
};
const fetchData = () => {
  AccountApi.getAllAccount().then((response) => {
    getAllAccount.value = response.data;
    console.log(response.data);
  });
};

watchEffect(() => {
  fetchData();
  getOne(getOneAccount.value);
  getPageAccount(getPage);
});
</script>
<style scoped></style>

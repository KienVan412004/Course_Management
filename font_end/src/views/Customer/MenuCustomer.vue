<template>
  <div>
    <div style="padding: 2">
      <div
        class="container-fluid"
        style="background-color: white; height: 80px"
      >
        <div class="row">
          <div
            style="
              display: flex;
              align-items: center;
              justify-content: center;
              margin-top: 10px;
            "
            class="col-3"
          >
            <img src="/img/logoCustomer.png" alt="" />
          </div>
          <div
            class="col-6"
            style="display: flex; align-items: center; justify-content: center"
          >
            <span class="title-menu-customer">
              <a href="/customer-home" style="text-decoration: none"
                >Giới thiệu</a
              ></span
            >
            <span class="title-menu-customer">Khóa học dành cho ai</span>
            <span class="title-menu-customer">Liên hệ</span>
          </div>
          <div
            class="col-3"
            style="
              display: flex;
              justify-content: center;
              align-items: center;
              margin-top: 10px;
            "
          >
            <img
              src="/img/facebook2.png"
              alt="notififcation"
              style="width: 60px; height: 40px; margin-left: 10px"
            />
            <img
              src="/img/youtobe2.webp"
              alt="user"
              style="width: 60px; height: 60px; margin-left: 10px"
            />
          </div>
        </div>
      </div>

      <div style="background-color: #f7f7f9; min-height: 640px">
        <slot />
      </div>
    </div>
  </div>
</template>
<style scoped>
.title-menu-customer {
  font-size: 20px;
  margin-right: 40px;
  font-weight: 600;
}
</style>

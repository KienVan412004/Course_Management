import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import Menu from "../layout/Menu.vue";
import Account from "../views/Account.vue";
import Course from "../views/course/Course.vue";
import Student from "../views/student/Student.vue";
import Teacher from "../views/teacher/Teacher.vue";
import DetailCourse from "../views/course/DetailCourse.vue";
import DetailSubject from "@/views/subject/DetailSubject.vue";
import DetailClasses from "@/views/classs/DetailClasses.vue";
import Classes from "@/views/classs/Classes.vue";
import Score from "@/views/Score/Score.vue";
import Point from "@/views/Point.vue";
import DetailPoint from "@/views/point/DetailPoint.vue";
import TabPoint from "@/views/point/TabPoint.vue";
import Login from "@/views/Login/Login.vue";
import DetailTeacher from "@/views/teacher/DetailTeacher.vue";
import MenuCustomer from "@/views/Customer/MenuCustomer.vue";
import HomeCustomer from "@/views/Customer/HomeCustomer.vue";
import DetailCourseCustomer from "@/views/Customer/DetailCourseCustomer.vue";
import Tesst from "@/views/Customer/Tesst.vue";
import PointStudent from "@/views/point/PointStudent.vue";
import SendMail from "@/views/SendMail/SendMail.vue";
import AccountMail from "@/views/AccountMail/AccountMail.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: HomeView
    // },
    {
      path: "/",
      name: "menu",
      component: Menu,
    },
    {
      path: "/account",
      name: "account",
      component: Account,
      // meta: { requiresAuth: true, allowedRoles: ["ADMIN"] },
    },
    {
      path: "/course",
      name: "course",
      component: Course,
      // meta: { requiresAuth: true, allowedRoles: ["ADMIN"] },
    },
    {
      path: "/student",
      name: "student",
      component: Student,
      // meta: { requiresAuth: true, allowedRoles: ["ADMIN"] },
    },
    {
      path: "/teacher",
      name: "teacher",
      component: Teacher,
      // meta: { requiresAuth: true, allowedRoles: ["ADMIN"] },
    },
    {
      path: "/detail-course/:id",
      name: "detailCourse",
      component: DetailCourse,
    },
    {
      path: "/detail-subject/:id",
      name: "detailSubject",
      component: DetailSubject,
    },
    {
      path: "/detail-classes/:id",
      name: "detailClasses",
      component: DetailClasses,
    },
    {
      path: "/classes",
      name: "classes",
      component: Classes,
      // meta: { requiresAuth: true, allowedRoles: ["ADMIN"] },
    },
    {
      path: "/score",
      name: "score",
      component: Score,
    },
    {
      path: "/point",
      name: "point",
      component: Point,
    },
    {
      path: "/detail-points/:id",
      name: "detailPoints",
      component: DetailPoint,
    },
    {
      path: "/detail-points-subject/:id",
      name: "tabPoints",
      component: TabPoint,
    },
    {
      path: "/login",
      name: "login",
      component: Login,
    },
    {
      path: "/detail-class-teacher/:id",
      name: "detailTeacher",
      component: DetailTeacher,
    },
    {
      path: "/customer-menu",
      name: "customerMenu",
      component: MenuCustomer,
    },
    {
      path: "/customer-home",
      name: "customerHome",
      component: HomeCustomer,
    },
    {
      path: "/detail-course-customer/:id",
      name: "detailCourseCustomer",
      component: DetailCourseCustomer,
    },
    {
      path: "/tesst",
      name: "tesst",
      component: Tesst,
    },
    {
      path: "/point-student",
      name: "pointStudent",
      component: PointStudent,
    },
    {
      path: "/send-mail",
      name: "sendMail",
      component: SendMail,
    },
    {
      path: "/account-mail",
      name: "accountMail",
      component: AccountMail,
    },

    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/AboutView.vue"),
    },
  ],
});

export default router;

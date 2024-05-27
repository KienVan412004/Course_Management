import Swal from "sweetalert2";

export default function Confirm(title: string, text: string) {
  return Swal.fire({
    title: title,
    text: text,
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#F2721E",
    cancelButtonColor: "#FF3333",
    confirmButtonText: "Vâng!",
    cancelButtonText: "Hủy",
  });
}

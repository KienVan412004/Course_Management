export default interface Account {
  id?: String;
  email: String;
  password: String;
  fullName?: String;
  phoneNumber: String;
  status: Number;
  role: Number;
  gender: Number;
  dateOfBirth: Date;
}

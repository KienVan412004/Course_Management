export default interface Course {
  id?: string;
  name: string;
  description?: string;
  startDate?: Date;
  endDate?: Date;
  totalStudent: number;
  subjectName: String[];
  price: number;
  image: string;
  estimatedStartTime: string;
  imageHome: string;
}

import axios from "axios";
import ReactPaginate from 'react-paginate';


export const getAllBlog = async () => {
  try {
    const res = await axios.get(`http://localhost:8080/api/blog/`);
    console.log(res);
    return res;
  } catch (error) {
    console.error(error);
  }
};
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
export const addNewBlog = async (blog) => {
  try {
    await axios.post("http://localhost:3001/api/blog/addNewBlog/ ", blog);
    return true;
  } catch (error) {
    return false;
  }
};


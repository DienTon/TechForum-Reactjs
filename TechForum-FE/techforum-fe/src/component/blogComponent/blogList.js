import { useEffect, useState } from "react";
import * as blogService from '../../service/blogService';
import Modal from "react-modal";
import axios from "axios";
import { toast } from "react-toastify";
import ReactPaginate from "react-paginate";

function BlogList(props) {
  const [blogList, setBlogList] = useState([]);

  useEffect(() => {
    getAll();
  }, []); // Thêm dependency array để chỉ gọi getAll() một lần

  const getAll = async () => {
    try {
      const response = await blogService.getAllBlog();
      if (response.data && Array.isArray(response.data.content)) {
        setBlogList(response.data.content);
      } else {
        console.error("Expected 'content' to be an array but got: ", response.data);
      }
    } catch (error) {
      console.error("Error fetching blog list", error);
    }
  };

  return (
    <>
      <h1 style={{ textAlign: "center" }}>List book</h1>
      <table className="table table-hover">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Content</th>
            <th scope="col">User</th>
            <th scope="col">Category</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          {blogList.map((blog, index) => (
            <tr key={blog.id}>
              <th scope="row">{index + 1}</th>
              <td>{blog.title}</td>
              <td>{blog.content}</td>
              <td>{blog.user.email}</td>
              <td>{blog.category.name}</td>
              <td>
                {/* Add Action buttons or links here */}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}

export default BlogList;

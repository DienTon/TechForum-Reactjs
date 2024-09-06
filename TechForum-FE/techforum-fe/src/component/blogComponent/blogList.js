import { useEffect, useState } from "react";
import * as blogService from "../../service/blogService";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import { ErrorMessage, Field, Form, Formik } from "formik";
import axios from "axios";
import { toast } from "react-toastify";
import * as Yup from "yup";
import ReactPaginate from "react-paginate";
import "../../css/blogListStyle.css";
import { Link } from "react-router-dom";

function BlogList(props) {
  const [blogList, setBlogList] = useState([]);
  const [dropdownState, setDropdownState] = useState({});
  const [show, setShow] = useState(false);

  const toggleDropdown = (id) => {
    setDropdownState((prevState) => ({
      ...prevState,
      [id]: !prevState[id],
    }));
  };

  useEffect(() => {
    getAll();
  }, []); // Thêm dependency array để chỉ gọi getAll() một lần

  const getAll = async () => {
    try {
      const response = await blogService.getAllBlog();
      if (response.data && Array.isArray(response.data.content)) {
        setBlogList(response.data.content);
      } else {
        console.error(
          "Expected 'content' to be an array but got: ",
          response.data
        );
      }
    } catch (error) {
      console.error("Error fetching blog list", error);
    }
  };
  const initialValues = {
    category: "",
    title: "",
    content: "",
  };
  const validationSchema = Yup.object({
    category: Yup.string().required("Chủ đề là bắt buộc"),
    title: Yup.string().required("Tiêu đề là bắt buộc"),
    content: Yup.string().required("Nội dung là bắt buộc"),
  });

  const onSubmit = (values) => {
    console.log(values);
  };
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  return (
    <>
      <div className="blogList-style">
        <body style={{ backgroundColor: "rgb(250, 250, 250)" }}>
          <div className="navigation">
            <div className="wrap-content-nav">
              <div className="wrap-icon-text">
                <div>
                  <img
                    src="https://firebasestorage.googleapis.com/v0/b/photo-archive-a0523i1.appspot.com/o/imgLanding%2Fz5572534420005_08dcdd6cfb1da3bbd58ccc7998f00f79.jpg?alt=media&token=706f832f-fd7a-4880-95bf-9bc0354c2e7b"
                    alt="Icon"
                    width="25"
                    height="29"
                  />
                </div>
                <div>
                  <h2>
                    <strong>BDĐHNT</strong>
                  </h2>
                </div>
              </div>
              <div className="wrap-btn">
                <Button variant="primary" onClick={handleShow}>
                  <i className="fa-solid fa-circle-plus"></i> Đăng Bài
                </Button>
                <div className="avt_func">
                  <div className="d-flex align-items-center">
                    <img
                      src="https://firebasestorage.googleapis.com/v0/b/photo-archive-a0523i1.appspot.com/o/imgLanding%2Fz5572534439426_12e9a1d7d2b51721634af3d654e8c21b.jpg?alt=media&token=6fa5eb7d-4293-4552-b680-c8951492269d"
                      alt="Avatar"
                    />
                    <i
                      style={{ marginLeft: "15px" }}
                      className="fa-solid fa-caret-down"
                    ></i>
                  </div>
                  <div className="wrap-drop-personal">
                    <a href="#">
                      <i className="fa-regular fa-user"></i> Thông tin cá nhân
                    </a>
                    <a href="#">
                      <i className="fa-solid fa-arrow-right-from-bracket"></i>{" "}
                      Đăng xuất
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div className="Sidebar">
            <div className="content-menu">
              <div style={{ margin: "30px 0", paddingLeft: "90px" }}>
                {/* Your form logic if needed */}
              </div>
              <div>
                <h4
                  style={{
                    padding: "15px 0 15px 90px",
                    borderTop: "1px solid #EAEAEA",
                  }}
                >
                  <strong>MENU</strong>
                </h4>
                <div className="item-menu">
                  <div className="menu-task">
                    <i
                      className="fa-solid fa-list"
                      style={{ marginRight: "10px" }}
                    ></i>
                    <a href="#">
                      <strong>Bài Viết</strong>
                    </a>
                  </div>
                  <div
                    className="menu-task"
                    onClick={() => toggleDropdown("dropdown-1")}
                  >
                    <i
                      className="fa-solid fa-tag"
                      style={{ marginRight: "10px" }}
                    ></i>
                    <p>
                      <strong>Chủ Đề</strong>
                    </p>
                  </div>
                  <div
                    id="dropdown-1"
                    className={`dropdown-content ${
                      dropdownState["dropdown-1"] ? "show" : ""
                    }`}
                  >
                    {/* Dropdown content */}
                  </div>
                </div>
              </div>
            </div>
            <div className="icon-contact">
              <a href="#">
                <i className="fa-brands fa-github"></i>
              </a>
              <a href="#">
                <i className="fa-brands fa-facebook"></i>
              </a>
              <a href="#">
                <i className="fa-brands fa-tiktok"></i>
              </a>
              <a href="#">
                <i className="fa-solid fa-envelope"></i>
              </a>
            </div>
          </div>
          {blogList.map((blog) => (
            <div className="Post">
              <div className="wrap-post">
                <div className="main-post">
                  <Link href="#" key={blog.id}>
                    <div className="info-post">
                    <img src="https://firebasestorage.googleapis.com/v0/b/photo-archive-a0523i1.appspot.com/o/imgLanding%2Fz5572534439426_12e9a1d7d2b51721634af3d654e8c21b.jpg?alt=media&token=6fa5eb7d-4293-4552-b680-c8951492269d"
                             alt=""></img>
                      <div style={{ width: "230px" }}>
                        <p>
                          <strong>{blog.user.email}</strong>
                        </p>
                        <p style={{ color: "#808080", fontSize: "13px" }}>
                          {blog.creationDate}
                        </p>
                      </div>
                    </div>
                    <div className="title-post">
                      <strong>
                        <h3 className="name_post">{blog.title}</h3>
                      </strong>
                    </div>
                    <div className="wrap-item-post d-flex justify-content-between align-items-center">
                      <div>
                        <p className="st_cate">{blog.category.name}</p>
                      </div>
                      <div className="d-flex justify-content-between align-items-center">
                        <div className="icon-number">
                          <i className="fa-regular fa-heart"></i>
                          <p>{blog.likes.length}</p>
                        </div>
                        <div className="icon-number">
                          <i className="fa-regular fa-eye"></i>
                          <p>{blog.viewBlog}</p>
                        </div>
                        <div className="icon-number">
                          <i className="fa-regular fa-message"></i>
                          <p>{blog.comments.length}</p>
                        </div>
                      </div>
                    </div>
                  </Link>
                </div>
              </div>
            </div>
          ))}

          {/* <!-- Modal --> */}
          
          <div className="modal-dialog">

          <Modal show={show} onHide={handleClose} >
            <Modal.Header closeButton>
              <Modal.Title>Modal heading</Modal.Title>
            </Modal.Header>
            <Modal.Body>
            <Formik
                initialValues={initialValues}
                validationSchema={validationSchema}
                onSubmit={onSubmit}
              >
                {({ errors, touched }) => (
                  <Form>
                    <div >
                      <label htmlFor="inputCate" className="form-label">
                        Chủ đề:
                      </label>
                      <Field
                        as="select"
                        className="form-select"
                        id="inputCate"
                        name="category"
                      >
                        <option value="">--Chọn chủ đề--</option>
                        <option value="chude1">Chủ đề 1</option>
                        <option value="chude2">Chủ đề 2</option>
                      </Field>
                      {errors.category && touched.category ? (
                        <p className="text-danger">{errors.category}</p>
                      ) : null}
                    </div>

                    <div>
                      <label htmlFor="inputName" className="form-label">
                        Tiêu đề:
                      </label>
                      <Field
                        type="text"
                        className="form-control"
                        id="inputName"
                        name="title"
                      />
                      {errors.title && touched.title ? (
                        <p className="text-danger">{errors.title}</p>
                      ) : null}
                    </div>

                    <div >
                      <label htmlFor="inputContent" className="form-label">
                        Nội dung:
                      </label>
                      <Field
                        as="textarea"
                        rows="17"
                        className="form-control"
                        id="inputContent"
                        name="content"
                      />
                      {errors.content && touched.content ? (
                        <p className="text-danger">{errors.content}</p>
                      ) : null}
                    </div>

                    <div className="modal-footer">
                      <button type="submit" className="btn"  onClick={handleClose}>
                        Đăng
                      </button>
                    </div>
                  </Form>
                )}
              </Formik>
            </Modal.Body>
          </Modal>
          </div>

          {/* <script>
    function toggleDropdown(id) {
        var dropdown = document.getElementById(id);
        if (dropdown.style.display === "none" || dropdown.style.display === "") {
            dropdown.style.display = "block";
        } else {
            dropdown.style.display = "none";
        }
    }
</script> */}
        </body>
      </div>
    </>
  );
}

export default BlogList;

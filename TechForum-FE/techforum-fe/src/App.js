import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import BlogList from '../src/component/blogComponent/blogList';
import 'bootstrap/dist/css/bootstrap.css';
import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
   <>
    <BrowserRouter>
       <Routes>
       <Route path="/blogList" element={<BlogList />}></Route>
       </Routes>
     </BrowserRouter>
     <ToastContainer />
   </>
  );
}

export default App;

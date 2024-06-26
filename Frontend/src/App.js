import './App.css';
import NavBar from './components/NavBar/NavBar';
import QuizState from './context/QuizState';
import Home from './pages/Home/Home';
import {Routes, Route} from "react-router-dom";
import About from './pages/About/About';
import ReviewAnswer from './pages/Review/ReviewAnswer';
import {useContext, useEffect} from "react";
import quizContext from "./context/quizContext";

function App() {

  const context = useContext(quizContext);
  const {setTitle} = context;

  useEffect(() => {
    document.title="Team1StudyWithMe - Exam online platform";
    setTitle(document.title);
  }, [document.title]);

  return (
    <>
      <>
        <div className="App">
          <NavBar />
          <Routes>
            <Route exact path="/" element={<Home />} />
            <Route exact path="/view/point" element={<Home />} />
            <Route exact path="/about" element={<About />} />
            <Route exact path="/review" element={<ReviewAnswer />} />
          </Routes>
        </div>
      </>
    </>
  );
}

export default App;

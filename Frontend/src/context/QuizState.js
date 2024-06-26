import QuizContext from "./quizContext";
import { useEffect, useState } from "react";


const QuizState = (props) => {

    const [questions, setQuestions] = useState([]);
    const [score, setScore] = useState({ 'rightAnswers': 0, 'wrongAnswers': 0 });
    const [next, setNext] = useState(0);
    // const demoURL = 'https://opentdb.com/api.php?amount=4&category=&difficulty=&type=boolean'
    const [url, setUrl] = useState('');
    const [loading, setLoading] = useState(false);
    const len = questions.length;
    const [answerList, setAnswerList] = useState([])
    const [username, setUsername] = useState('');
    const [timeLimit, setTimeLimit] = useState(0);
    const [startTime , setStartTime] = useState('');
    const [endTime , setEndTime] = useState('');
    const [totalTestDurationTime , setTotalTestDurationTime] = useState(0);
    const [userId, setUserId] = useState('');
    const [category, setCategory] = useState('');
    const [type, setType] = useState('');
    const [difficulty, setDifficulty] = useState('');
    const [title, setTitle] = useState('');

    const fetchQuestions = async (api) => {
        const response = await fetch(api);
        const data = await response.json();
        let results = data.results;
        setQuestions(results);
        setLoading(false);
    };

    useEffect(() => {
        fetchQuestions(url).then(
            res=>{
                console.log(res);
            }
        ).catch(
            err=>{
                console.error(err);
            }
        );
    }, [url]);


    return (
        <QuizContext.Provider value={{ answerList, setAnswerList, len,
            questions, setQuestions, url, setUrl, fetchQuestions,
            loading, setLoading, score, setScore, next, setNext ,
            username, setUsername, setTimeLimit, timeLimit,
            setStartTime, startTime, setEndTime, endTime,
            setTotalTestDurationTime, totalTestDurationTime,
            setUserId, userId, setCategory, category,
            setType, type, setDifficulty, difficulty,
            setTitle, title
        }}>
            {props.children}
        </QuizContext.Provider>
    )
}

export default QuizState
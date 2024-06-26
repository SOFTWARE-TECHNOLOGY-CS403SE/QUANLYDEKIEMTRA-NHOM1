import React, {useContext, useEffect, useState} from 'react'
import Form from '../../components/Form/Form'
import QuizArea from '../QuizArea/QuizArea'
import quizContext from '../../context/quizContext'
import { HashLoader } from 'react-spinners';
import { Text } from '@chakra-ui/react'
import logo from "../../Assets/logo_team1.png"
import styles from "../../Assets/css/styles.module.css"
import {useNavigate} from "react-router-dom";
import {getApi} from "../../request/api";

const Home = () => {

    const navigate = useNavigate();
    const context = useContext(quizContext);
    const { setUrl, url, fetchQuestions, setLoading,
    loading, questions, setUsername, setTimeLimit,
    setStartTime, setEndTime, setTotalTestDurationTime,
    setUserId, setType, setDifficulty, title} = context
    const [formData, setFormData] = useState({username :'', number: '', category: '', difficulty: '', type: '' , timer : 0})
    const milliseconds = Date.now();
    const date = new Date(milliseconds);
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hours = date.getHours();
    const minutes = date.getMinutes();
    const seconds = date.getSeconds();

    useEffect(() => {
        getApi("/home").then(
            res=>{

            }
        ).catch(
            err=>{
                console.error("err ",err);
            }
        )
    }, []);

    const getUserId = () => {
        return "userId";
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        const {username,timer, number, category,
        difficulty, type } = formData;
        const userId = localStorage.getItem(getUserId());

        if (!userId) {
            setUsername(username);
            setTimeLimit(timer);
            setStartTime(`${day}-${month}-${year} ${hours}:${minutes}:${seconds}`);
            setEndTime(`${day}-${month}-${year} ${hours}:${minutes}:${seconds + (number * timer)}`);
            setTotalTestDurationTime(number * timer);
            setUserId(getUserId());
            setType(type);
            setDifficulty(difficulty);

            // Lưu thời gian bắt đầu vào localStorage
            localStorage.setItem(getUserId(), Date.now());
            setUrl(`https://opentdb.com/api.php?amount=${number}&category=${category}&difficulty=${difficulty}&type=${type}`, fetchQuestions(url))
            setLoading(true)
        }
        console.log("block")
        navigate("/");
        // window.location.reload();

    }

    const onChange = (e) => {

        setFormData({ ...formData, [e.target.name]: e.target.value })
    }

    return (
        <>
            <div className="d-flex justify-content-center align-items-center">
                <HashLoader
                    color={'#3585c1'}
                    loading={loading}
                    size={100}
                    aria-label="Loading Spinner"
                    data-testid="loader"
                    style={{ backgroundColor: '#4d4d4dcc', width: '100%', height: '100vh', position: 'absolute', top: '13%' }}
                />
            </div>
            {
                (url === '' || questions.length === 0)
                    ?
                    <div className={`container ${styles.marginTop_50px}`}>
                        <div>
                            <img width="65px" className={`${styles.floatLeft} ${styles.marginRight_10px}`}
                                 src={logo ? logo : ''}
                                 alt={logo ? logo : ''}
                            />
                            <Text width="100%" mb={'4'}  fontSize='4xl'>{title}</Text>
                        </div>

                        <Form style={styles.clearBoth} handleSubmit={handleSubmit} onChange={onChange} />
                    </div>
                    :
                    <QuizArea />
            }
        </>
    )
}

export default Home

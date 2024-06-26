import React, {useEffect} from 'react'
import { useContext } from 'react'
import './Scoreboard.css'
import { AiOutlineHome, AiOutlineEye } from 'react-icons/ai'
import { BiReset } from 'react-icons/bi'
import { BsShare } from 'react-icons/bs'
import quizContext from '../../context/quizContext'
import { Link as ReachLink } from 'react-router-dom'
import {postApi} from "../../request/api";

const Scoreboard = (props) => {
    const context = useContext(quizContext)
    const { setNext, setScore, setAnswerList, setEndTime } = context;
    const { username, startTime, timeLimit, endTime, userId,
    category, type, difficulty} = context;
    const { total_que, correct_que, wrong_que } = props;
    let Attempted = (correct_que + wrong_que) / total_que * 100;
    let point = parseFloat(correct_que * (10 / total_que)).toFixed(2);
    let totalTime = parseFloat((timeLimit * total_que) / 60).toFixed(2);

    const handleGoHome = () => {
        window.location.reload();
    }

    useEffect(() => {
        postApi("/home", {
            startTime : startTime,
            endTime : endTime,
            username : username,
            correct_que : correct_que,
            wrong_que : wrong_que,
            attempted : Attempted,
            test_duration : totalTime,
            point : point,
            category : category,
            type : type,
            difficulty : difficulty
        }).then(
            res=>{

            }
        ).catch(
            error=>{
                console.error("err ", error);
            }
        );
    }, []);

    useEffect(() => {
        localStorage.removeItem(userId);
    }, []);

    const handlePlayAgain = () => {
        setNext(0)
        setScore({ 'rightAnswers': 0, 'wrongAnswers': 0 })
        setAnswerList([])
    }
    return (
        <>
            <div className="main">
                <div className="score">
                    Your Score <br />
                    {/*<span>{percentage.toFixed(2)} <small>%</small></span>*/}
                    {`${point} đ`}
                </div>
                <div className="point-table">

                    <div className="semi-table">
                        <div style={{backgroundColor: '#A45EDA'}} className="circle"></div>
                        <div className='mx-2'>
                            <div className="point-info">
                                Start time
                            </div>
                            <div style={{
                                color: '/*#A45EDA*/#fff',
                                background: "#212832",
                                padding: "0.5rem",
                                borderRadius: "0.5rem"
                            }} className="point">
                                {`${startTime}`}
                            </div>
                        </div>
                    </div>

                    <div className="semi-table">
                        <div style={{backgroundColor: '#A45EDA'}} className="circle"></div>
                        <div className='mx-2'>
                            <div className="point-info">
                                End time
                            </div>
                            <div style={{
                                color: '/*#A45EDA*/#fff',
                                background: "#212832",
                                padding: "0.5rem",
                                borderRadius: "0.5rem"
                            }} className="point">
                                {`${endTime}`}
                            </div>
                        </div>
                    </div>

                    <div className="semi-table">
                        <div style={{backgroundColor: '#A45EDA'}} className="circle"></div>
                        <div className='mx-2'>
                            <div className="point-info">
                                Your name
                            </div>
                            <div style={{
                                color: '/*#A45EDA*/#fff',
                                background: "#212832",
                                padding: "0.5rem",
                                borderRadius: "0.5rem"
                            }} className="point">
                                {`${username}`}
                            </div>
                        </div>
                    </div>

                    <div className="semi-table">
                        <div style={{backgroundColor: '#A45EDA'}} className="circle"></div>
                        <div className='mx-2'>
                            <div className="point-info">
                                Test duration
                            </div>
                            <div style={{
                                color: '/*#A45EDA*/#fff',
                                background: "#212832",
                                padding: "0.5rem",
                                borderRadius: "0.5rem"
                            }} className="point">
                                {`${totalTime} m`}
                            </div>
                        </div>
                    </div>

                    <div className="semi-table">
                        <div style={{backgroundColor: '#A45EDA'}} className="circle"></div>
                        <div className='mx-2'>
                            <div className="point-info">
                                Attempted
                            </div>
                            <div style={{
                                color: '/*#A45EDA*/#fff',
                                width: "5.8rem",
                                background: "#212832",
                                padding: "0.5rem",
                                borderRadius: "0.5rem"
                            }} className="point">{Attempted.toFixed(2)}%
                            </div>

                        </div>
                    </div>
                    <div className="semi-table">
                        <div style={{backgroundColor: '#A45EDA'}} className="circle"></div>
                        <div className='mx-2'>
                            <div className="point-info">
                                Total Questions
                            </div>
                            <div style={{
                                color: '#fff',
                                width: "5.8rem",
                                background: "#212832",
                                padding: "0.5rem",
                                borderRadius: "0.5rem"
                            }} className="point">{total_que}</div>

                        </div>
                    </div>
                    <div className="semi-table">
                        <div style={{backgroundColor: 'rgb(6 143 86)'}} className="circle"></div>
                        <div className='mx-2'>
                            <div className="point-info">
                                Correct
                            </div>
                            <div style={{
                                color: '/*rgb(6 143 86)*/#fff',
                                background: "#212832",
                                padding: "0.5rem",
                                width: "5.8rem",
                                borderRadius: "0.5rem"
                            }} className="point">{correct_que}</div>

                        </div>
                    </div>
                    <div className="semi-table">
                        <div style={{backgroundColor: 'rgb(223 75 75)'}} className="circle"></div>
                        <div className='mx-2'>
                            <div className="point-info">
                                Wrong
                            </div>
                            <div style={{
                                color: '/*rgb(223 75 75)*/#fff',
                                width: "5.8rem",
                                background: "#212832",
                                padding: "0.5rem",
                                borderRadius: "0.5rem"
                            }} className="point">{wrong_que}</div>

                        </div>
                    </div>

                </div>

                <div className="footer">
                    <div className="text-center" onClick={handleGoHome}>
                        <div style={{backgroundColor: '#BE709F'}} className="home-btn">
                            <AiOutlineHome/>
                        </div>
                        <div className='footer-text'>Home</div>
                    </div>
                    <div className="text-center">
                        <div style={{backgroundColor: '#755ED3'}} className="home-btn">
                            <BsShare/>
                        </div>
                        <div className='footer-text'>Share Score</div>
                    </div>
                    <div className="text-center">
                        <ReachLink to='/review'>
                        <div style={{ backgroundColor: '#BF8D6F' }} className="home-btn">
                                <AiOutlineEye />
                            </div>
                        </ReachLink>
                        <div className='footer-text'>
                            Review Answer
                        </div>
                    </div>
                    <div className="text-center" onClick={handlePlayAgain}>
                        <div style={{ backgroundColor: '#5492B3' }} className="home-btn">
                            <BiReset />
                        </div>
                        <div className='footer-text'>Play Again</div>
                    </div>
                </div>
            </div>

        </>
    )
}

export default Scoreboard

import React, {useContext, useEffect, useState} from 'react';
import PropTypes from 'prop-types';
import quizContext from "../../context/quizContext";
import {useNavigate} from "react-router-dom";

const TotalTestDurationTime = props => {

    const context = useContext(quizContext);
    const {totalTestDurationTime, userId} = context;
    const navigate = useNavigate();
    const [totalTestDurationTimer, setTotalTestDurationTimer] = useState('');

    const getUserId = () => {
        return "userId";
    }

    useEffect(  () => {

        // Lấy thời gian bắt đầu từ localStorage
        const startTime = localStorage.getItem(userId);
        const waitTime = totalTestDurationTime; // Thời gian chờ

        console.log(startTime);

        // Kiểm tra nếu có startTime
        if (startTime) {
            const timerInterval = setInterval(async () => {
                // Thời gian trôi qua tính bằng giây
                const elapsedTime = (Date.now() - startTime) / 1000;
                // Thời gian còn lại để chờ
                const remainingTime = waitTime - elapsedTime;

                console.log("thời gian trôi qua ", elapsedTime);
                console.log("thời gian còn lại ", remainingTime);

                // nếu thời gian còn lại <= 0 thì sẽ xóa user trong localStorage đi
                if (remainingTime <= 0) {
                    clearInterval(timerInterval);
                    localStorage.removeItem(userId); // Xóa thời gian bắt đầu khỏi localStorage

                    await new Promise(resolve => setTimeout(resolve, 1000));
                    window.location.reload();
                } else {
                    const hours = Math.floor(remainingTime / 3600);
                    const minutes = Math.floor((remainingTime % 3600) / 60);
                    const seconds = Math.floor(remainingTime % 60);

                    setTotalTestDurationTimer(`${minutes}:${seconds}s`);
                }
            }, 1000); // Cập nhật thời gian mỗi giây

            // Xóa bộ đếm khi unmount
            return () => clearInterval(timerInterval);
        }
    }, [userId]);


    return (
        <>
            <span>
                Test duration
            </span>
            <span>
                {` ${totalTestDurationTimer}`}
            </span>
        </>
    );
};

TotalTestDurationTime.propTypes = {
    
};

export default TotalTestDurationTime;
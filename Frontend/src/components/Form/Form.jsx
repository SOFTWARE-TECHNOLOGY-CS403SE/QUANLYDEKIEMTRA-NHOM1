import React, {useContext, useState} from 'react'
import quizData from '../../components/TriviaQuizData'
import quizContext from "../../context/quizContext";

const Form = (props) => {

    const { handleSubmit, onChange } = props;
    const context = useContext(quizContext)
    const { setCategory } = context;

    const getOptionsValue = (data) => {

        return data.map((item) => {
            let objectKeys = Object.keys(item)[0]
            return <option key={objectKeys} value={item[objectKeys]}>{objectKeys}</option>
        });
    }


    const handleCategoryChange = (event) => {
        const selectedValue = event.target.value;
        if (selectedValue === 'any') {
            setCategory('any');
            if (onChange) {
                onChange(event);
            }
            return;
        }
        const selectedOption = quizData.category.find(item => item[Object.keys(item)[0]] == selectedValue);
        console.log('Selected Option:', selectedOption);

        if (selectedOption) {
            const selectedKey = Object.keys(selectedOption)[0];
            console.log('Selected Key:', selectedKey);
            setCategory(selectedKey);
        } else {
            console.error('Not found!');
        }
        if (onChange) {
            onChange(event);
        }
    };



    return (
        <div className={props.style}>
            <form className='mt-2' onSubmit={handleSubmit}>

                <div className="mb-3">
                    <label htmlFor="number" className="form-label">Number of Questions:</label>
                    <input placeholder='Enter Number of Questions' type="number" name='number' className="form-control"
                           id="number" onChange={onChange} required/>
                </div>

                <div className="mb-3">
                    <label htmlFor="number" className="form-label">Your name:</label>
                    <input placeholder='Enter your name' type="text" name='username' className="form-control"
                    id="username" onChange={onChange} required/>
                </div>

                <div className="mb-3">
                    <label htmlFor="number" className="form-label">Time limit / 1 Question:</label>
                    <input placeholder='Enter time limited' type="number" name='timer' className="form-control"
                           id="timer" onChange={onChange} required/>
                </div>

                <div className="mb-3">
                    <label htmlFor="category" className="form-label">Select Category:</label>
                    <select name='category' className="form-select" aria-label="Default select example"
                            onChange={handleCategoryChange}>
                        <option value={'any'} defaultValue>Any Category</option>
                        {
                            getOptionsValue(quizData.category)
                        }
                    </select>
                </div>
                <div className="mb-3">
                    <label htmlFor="difficulty" className="form-label">Select Difficulty:</label>
                    <select name='difficulty' className="form-select" aria-label="Default select example"
                            onChange={onChange}>
                        <option value={'any'} defaultValue>Any Difficulty</option>
                        {
                            getOptionsValue(quizData.difficulty)
                        }
                    </select>
                </div>
                <div className="mb-3">
                    <label htmlFor="type" className="form-label">Select Type:</label>
                    <select name='type' className="form-select" aria-label="Default select example" onChange={onChange}>
                        <option value={'any'} defaultValue>Any Type</option>
                        {
                            getOptionsValue(quizData.type)
                        }
                    </select>
                </div>
                <button type="submit" className="btn btn-primary">Start Quiz</button>
            </form>
        </div>
    )
}

export default Form

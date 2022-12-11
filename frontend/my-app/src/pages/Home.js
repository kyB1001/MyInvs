import {useEffect, useState} from "react";
import axios from "axios";

function Home() {


    return (
        <>
            <div className="container">
                <div className="row text-md-center">
                    <h3 className="mt-5">Welcome to your personal Realestate investment portal portfolio value</h3>
                </div>
                <div className="row mt-3">
                    <div className="col card text-md-center mx-3 py-5">
                        <h5> Total Poperties</h5>
                        <h1>50</h1>
                    </div>

                    <div className="col card text-md-center mx-3 py-5">
                        <h5> Total Units</h5>
                        <h1>50</h1>
                    </div>
                </div>
                <div className="row mt-3">
                    <div className="col card text-md-center mx-3 py-5">
                        <h5>Total occupancy</h5>
                        <h1>50</h1>
                    </div>

                    <div className="col card text-md-center mx-3 py-5">
                        <h5> Total Vacancy </h5>
                        <h1>50</h1>
                    </div>
                </div>

                <div className="row">
                        <div className="col text-md-center mx-3 py-5">
                            <h5>Portfolio Location</h5>
                            <h1>Florida</h1>
                        </div>
                </div>
            </div>

        </>
    );
}

export default Home;
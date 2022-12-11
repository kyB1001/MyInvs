import {useEffect, useState} from "react";
import { BsXCircleFill } from 'react-icons/bs';


import axios from "axios";

function Property() {

    const [properties, setProperties] = useState([])

    const [address, setAddress] = useState("")

    const [price, setPrice] = useState(0)

    const [type, setType] = useState("")

    const [bathrooms, setBathrooms] = useState(0)

    const [bedrooms, setBedrooms] = useState(0)

    const [sqft, setSqft] = useState(0)

    const [age, setAge] = useState(0)

    const [units, setUnits] = useState(0)

    const onAddresseChange = (e) => {
        setAddress(e.target.value)
    }

    const onPriceChange = (e) => {
        setPrice(e.target.value)
    }

    const onTypeChange = (e) => {
        setType(e.target.value)
    }

    const onBathroomsChange = (e) => {
        setBathrooms(e.target.value)
    }

    const onBedroomshange = (e) => {
        setBedrooms(e.target.value)
    }

    const onSqftChange = (e) => {
        setSqft(e.target.value)
    }

    const onAgeChange = (e) => {
        setAge(e.target.value)
    }

    const onUnitsChange = (e) => {
        setUnits(e.target.value)
    }

    const handleSubmit = (e) => {
        const proper = {
            "address": address,
            "price": price,
            "type": type,
            "bathrooms": bathrooms,
            "bedrooms": bedrooms,
            "squareFeet": sqft,
            "age": age,
            "units": units,
            "description": "N/A",
            "picture": "N/A"
        }

        const addProperty = () => {
            axios.post('http://localhost:8080/api/v1/property/', proper)
                .then(response => {
                        console.log(response.data)
                    }
                )
        }

        addProperty()

    }

    const handleDelete = (id) => {

        const deleteProperty = () => {
            const url = 'http://localhost:8080/api/v1/property/'+id
            axios.delete(url)
                .then(response => {
                        console.log(response)
                    }
                )
        }

        deleteProperty()

        setProperties(prevState => (
            prevState.filter(el => el.id != id )
        ));
    }


    useEffect(() => {

        const getProperties = async () => {
            await axios.get('http://localhost:8080/api/v1/property/')
                .then(response => {
                    response.data.map(proper => {
                        setProperties(OldValue => [...OldValue, proper])
                    })
                    console.log(response.data)
                })
        }

        getProperties().then(
            () => {
                console.log()
            }
        )


    }, []);

    return (
        <>
            <div className="container">
                <form>
                    <div className="row">
                        <div className="col-sm-2">
                            <input type="text" className="form-control" placeholder="address" onChange={onAddresseChange}/>
                        </div>
                        <div className="col-sm-2">
                            <input type="text" className="form-control" placeholder="type" onChange={onTypeChange}/>
                        </div>
                        <div className="col-sm-1">
                            <input type="text" className="form-control" placeholder="price" onChange={onPriceChange}/>
                        </div>
                        <div className="col-sm-1">
                            <input type="text" className="form-control" placeholder="bathrooms" onChange={onBathroomsChange}/>
                        </div>
                        <div className="col-sm-1">
                            <input type="text" className="form-control" placeholder="bedrooms" onChange={onBedroomshange}/>
                        </div>
                        <div className="col-sm-1">
                            <input type="text" className="form-control" placeholder="sqft" onChange={onSqftChange}/>
                        </div>
                        <div className="col-sm-1">
                            <input type="text" className="form-control" placeholder="age" onChange={onAgeChange}/>
                        </div>
                        <div className="col-sm-1">
                            <input type="text" className="form-control" placeholder="units" onChange={onUnitsChange}/>
                        </div>
                        <div className="col-sm-1">
                            <button type="submit" className="btn btn-primary" onClick={handleSubmit}>add</button>
                        </div>
                    </div>


                </form>
                <span className="glyphicon glyphicon-remove"></span>
                <table className="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Address</th>
                        <th scope="col">Type</th>
                        <th scope="col">Price</th>
                        <th scope="col">Bathrooms</th>
                        <th scope="col">Bedrooms</th>
                        <th scope="col">Sqft</th>
                        <th scope="col">Age</th>
                        <th scope="col">Units</th>

                    </tr>
                    </thead>
                    <tbody>
                {properties.map((proper, idx) => {
                        return (
                            <tr>
                                <th scope="row">{idx+1}</th>
                                <td>{proper["address"]}</td>
                                <td>{proper["type"]}</td>
                                <td>{proper["price"]}</td>
                                <td>{proper["bathrooms"]}</td>
                                <td>{proper["bedrooms"]}</td>
                                <td>{proper["squareFeet"]}</td>
                                <td>{proper["age"]}</td>
                                <td>{proper["units"]}</td>
                                <td><button onClick={() => handleDelete(proper["id"])}><BsXCircleFill/></button></td>

                            </tr>

                        )
                    }
                )}
                </tbody>
              </table>
            </div>

        </>
    );
}

export default Property;
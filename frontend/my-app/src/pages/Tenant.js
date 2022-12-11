import {useEffect, useState} from "react";
import { BsXCircleFill } from 'react-icons/bs';
import axios from "axios";

function Tenant() {

    const [tenants, setTenants] = useState([])

    const [lastname, setLastName] = useState("")

    const [firstname, setFirstName] = useState("")

    const [property, setProperty] = useState("")

    const [email, setEmail] = useState("")

    const [phone, setPhone] = useState("")


    const onLastNameChange = (e) => {
        setLastName(e.target.value)
        console.log(lastname)
    }

    const onFirstNameChange = (e) => {
        setFirstName(e.target.value)
    }

    const onPropertyChange = (e) => {
        setProperty(e.target.value)
    }

    const onEmailChange = (e) => {
        setEmail(e.target.value)
    }

    const onPhoneChange = (e) => {
        setPhone(e.target.value)
    }

    const handleSubmit = (e) => {
        const ten = {
            "lastname": lastname,
            "firstname": firstname,
            "property": property,
            "email": email,
            "phone": phone
        }

        const addTenant = () => {
            axios.post('http://localhost:8080/api/v1/tenant/', ten)
                .then(response => {
                        console.log(response)
                    }
                )
        }

        addTenant()

    }

    const handleDelete = (id) => {

        const deleteTenant = () => {
            const url = 'http://localhost:8080/api/v1/tenant/'+id
            axios.delete(url)
                .then(response => {
                        console.log(response)
                    }
                )
        }

        deleteTenant()

        setTenants(prevState => (
            prevState.filter(el => el.id != id )
        ));
    }


    useEffect(() => {

        const getTenants = async () => {
            await axios.get('http://localhost:8080/api/v1/tenant/')
                .then(response => {
                    response.data.map(ten => {
                        setTenants(OldValue => [...OldValue, ten])
                    })
                    console.log(response.data)
                })
        }

        getTenants().then(
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
                            <input type="text" className="form-control" placeholder="last" onChange={onLastNameChange}/>
                        </div>
                        <div className="col-sm-2">
                            <input type="text" className="form-control" placeholder="first" onChange={onFirstNameChange}/>
                        </div>
                        <div className="col-sm-1">
                            <input type="text" className="form-control" placeholder="property" onChange={onPropertyChange}/>
                        </div>
                        <div className="col-sm-1">
                            <input type="text" className="form-control" placeholder="email" onChange={onEmailChange}/>
                        </div>
                        <div className="col-sm-1">
                            <input type="text" className="form-control" placeholder="phone" onChange={onPhoneChange}/>
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
                        <th scope="col">First</th>
                        <th scope="col">Last</th>
                        <th scope="col">Property</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone</th>

                    </tr>
                    </thead>
                    <tbody>
                    {tenants.map((ten, idx) => {
                            return (
                                <tr>
                                    <th scope="row">{idx+1}</th>
                                    <td>{ten["firstname"]}</td>
                                    <td>{ten["lastname"]}</td>
                                    <td>{ten["property"]}</td>
                                    <td>{ten["email"]}</td>
                                    <td>{ten["phone"]}</td>
                                    <td><button onClick={() => handleDelete(ten["id"])}><BsXCircleFill/></button></td>

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

export default Tenant;
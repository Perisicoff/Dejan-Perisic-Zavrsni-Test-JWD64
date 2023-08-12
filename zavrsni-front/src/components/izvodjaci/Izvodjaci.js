import React, { useCallback, useEffect, useState } from 'react'
import { Alert, Button, Col, Form, Row, Table } from 'react-bootstrap';
import Axios from '../../apis/Axios';
import {IsLoggedIn} from '../../service/auth'
import '../../index.css'
import {Rola} from '../../service/auth'

const Izvodjaci = () => {

    const [izvodjaci, setIzvodjaci] = useState([])
    const [vali, SetVali] = useState(false)
      
    const getAll = useCallback(() => {
       
        Axios.get('/izvodjaci')
        .then(res => {
          console.log(res)
          setIzvodjaci(res.data)
        })
        .catch(err => {
          console.log(err)
        })
    }, [])

  
    useEffect(() => {
      getAll()
    }, [])

    const nastupiIZvodjaca = (brojNastupa) => {
      alert("Ovaj izvodjac ima " + brojNastupa + " nastupa!")
    }


    const rednerAll = () => {
      return izvodjaci.map((izvodjac) => {
        return(
          <tr onClick={() => nastupiIZvodjaca(izvodjac.brojNastupa)} key={izvodjac.id}>
            <td>{izvodjac.ime}</td>
            <td>{izvodjac.zanr}</td>
            <td>{izvodjac.drzava}</td>
            <td>{izvodjac.brojClanova}</td>
          </tr>
        )
      })

    }

    const izvodjac = {
      id: -1,
      ime: '',
      zanr: '',
      drzava: '',
      brojClanova: ''
  }

  const [noviIzvodjac, setNoviIzvodjac] = useState(izvodjac)

    const dodajIzvodjaca = () => {

      const dto = {
        ime: noviIzvodjac.ime,
        zanr: noviIzvodjac.zanr,
        drzava: noviIzvodjac.drzava,
        brojClanova: noviIzvodjac.brojClanova
      }

      Axios.post('/izvodjaci', dto)
          .then(res => {
              console.log(res)
              window.location.reload()
          })
          .catch(err => {
              console.log(err)
              alert("Doslo je do greske, pokusajte novi unos!")
          })
  }

  const valueInputChanged = (e) => {

    let input = e.target;
    let name = input.name;
    let value = input.value;

    noviIzvodjac[name] = value;
    setNoviIzvodjac(noviIzvodjac);
  }

  const validacija = () => {

    if (noviIzvodjac.ime == "" || noviIzvodjac.zanr == "" || noviIzvodjac.drzava == "" || noviIzvodjac.brojClanova == "") {
        return SetVali(false);
    }
    return SetVali(true);    

  }
    
    return (
      <div>
        {Rola() == "admin" && IsLoggedIn() && <div>
            <Col>
          <br/><br/><br/><br/>
          <Row><h1>Kreiraj novog izvodjaca</h1></Row>
          <br/>
          <Row>
            <Col></Col>
            <Col>
              <Form>
                <Form.Label htmlFor="ime">Naziv</Form.Label>
                <Form.Control id="ime" type="text" name="ime" onChange={(e) => valueInputChanged(e)} onKeyUp={() => validacija()}/>

                <Form.Label htmlFor="drzava">Drzava porekla</Form.Label>
                <Form.Control id="drzava" name="drzava" type="text" onChange={(e) => valueInputChanged(e)} onKeyUp={() => validacija()}/>

                <Form.Label htmlFor="zanr">Zanr</Form.Label>
                <Form.Control id="zanr" type="text" name="zanr" onChange={(e) => valueInputChanged(e)} onKeyUp={() => validacija()}/>

                <Form.Label htmlFor="brojClanova">Broj Clanova</Form.Label>
                <Form.Control id="brojClanova" type="number" min={0} name="brojClanova" onChange={(e) => valueInputChanged(e)} onKeyUp={() => validacija()}/>

                <br/>
                <Button disabled={vali == false} className="btn btn-success" onClick={() => dodajIzvodjaca()}>Kreiraj</Button>
              </Form>
            </Col>
            <Col></Col>
          </Row>
        </Col>
        </div>}
        <div>
        <Row className="justify-content-center">
        <Col>
          <br/><br/><br/><br/>
          <Row><h1>Izvodjaci</h1></Row>
          <br/>
          <Row>
            <Col>
              <Table>
                <thead>
                  <tr>
                    <th>Naziv</th>
                    <th>Zanr</th>
                    <th>Drzava porekla</th>
                    <th>Broj Clanova</th>
                  </tr>
                </thead>
                <tbody>
                  {rednerAll()}
                </tbody>
              </Table>
            </Col>
          </Row>
          <br/>
        </Col>
        </Row>
      </div>
      </div>
    );
}

export default Izvodjaci;
import React, { useCallback, useEffect, useState } from 'react'
import { Button, Col, Collapse, Form, Row, Table } from 'react-bootstrap';
import { useNavigate } from "react-router-dom";
import Axios from '../../apis/Axios';
import {IsLoggedIn} from '../../service/auth'
import '../../index.css'
import { Rola } from '../../service/auth'

const Nastupi = (props) => {

    var navigate = useNavigate()
    const [nastupi, setNastupi] = useState([])
    const [festivali, setFestivali] = useState([])
    const [izvodjaci, setIzvodjaci] = useState([])
    const [pageNo, setPageNo] = useState(0)
    const [totalPage, setTotalPage] = useState(0)
    const [isChecked, setIsChecked] = useState(false);
    const [searchParams, setSearchParams] = useState({
      festivalId: "",
      izvodjacId: ""
    })
  
    const getAll = useCallback((nextPage) => {
        const config = {
          params: {
            festivalId: searchParams.festivalId,
            izvodjacId: searchParams.izvodjacId,
            pageNo: nextPage
          }
        }
        Axios.get('/nastupi', config)
        .then(res => {
          console.log(res)
          setNastupi(res.data)
          setPageNo(nextPage)
          setTotalPage(res.headers["total-pages"])
        })
        .catch(err => {
          console.log(err)
        })
    }, [])

    const getAll2 = useCallback(() => {
      Axios.get('/festivali')
      .then(res => {
        console.log(res)
        setFestivali(res.data)
      })
      .catch(err => {
        console.log(err)
      })
    }, [])

    const getAll3 = useCallback(() => {
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
      getAll(pageNo)
      getAll2()
      getAll3()
    }, [])

    const obrisi = (nastupId) => {
      const confirmDelete = window.confirm("Da li ste sigurni da zelite da obrisete ovaj nastup?");
      if (confirmDelete) {
        Axios.delete('/nastupi/' + nastupId)
        .then(res => {
          console.log(res)
          setNastupi((nastupi)=>nastupi.filter(nastup => nastup.id !== nastupId))
        })
        .catch(err => {
          console.log(err)
        })
      } else {
        navigate('/nastupi')
      }
    }

    const rednerAll = () => {
      return nastupi.map((nastup) => {
        return(
          <tr key={nastup.id}>
            <td>{nastup.nazivIzvodjaca}</td>
            <td>{nastup.nazivFestivala}</td>
            {IsLoggedIn() && Rola() == "admin" && <td><Button className="btn btn-danger" onClick={() => obrisi(nastup.id)}>Ukloni</Button></td>}
          </tr>
        )
      })

    }

    const rednerAll2 = () => {
      return festivali.map((festival) => {
        return(<option key={festival.id} value={festival.id}>{festival.naziv}</option>)
      })

    }

    const rednerAll3 = () => {
        return izvodjaci.map((izvodjac) => {
          return(<option key={izvodjac.id} value={izvodjac.id}>{izvodjac.ime}</option>)
        })
  
      }

    const serchValue = (event) => {
      let name = event.target.name
      let value = event.target.value
      
      searchParams[name] = value
      setSearchParams(searchParams)
      getAll(0)
    }

    const nastup = {
        id: -1,
        festivalId: -1,
        izvodjacId: -1
    }
  
    const [noviNastup, setNoviNastup] = useState(nastup)
  
      const dodajNastup = () => {
  
        const dto = {
          festivalId: noviNastup.festivalId,
          izvodjacId: noviNastup.izvodjacId
        }
  
        Axios.post('/nastupi', dto)
            .then(res => {
                console.log(res)
                window.location.reload()
            })
            .catch(err => {
                console.log(err)
                alert("Kreiranje nije uspelo, na jednom festivalu moze biti samo jedan izvodjac po drzavi!")
            })
    }
  
    const valueInputChanged = (e) => {
  
      let input = e.target;
      let name = input.name;
      let value = input.value;
  
      noviNastup[name] = value;
      setNoviNastup(noviNastup);
    }
    
    return (
      <div>
        <Row className="justify-content-center">
        <Col>
          <br/><br/>
          <Row><h1>Nastupi</h1></Row>
          {IsLoggedIn() &&  <Form style={{marginTop:10}}>
                <Form.Group>
                    <Form.Label>Izvodjaci</Form.Label>
                    <Form.Select name='izvodjacId' onChange={(e) =>valueInputChanged(e)}>
                        <option value={""}>--izaberi izvodjaca--</option>
                        {rednerAll3()}
                    </Form.Select>
                    <Form.Group>
                    <Form.Label>Festivali</Form.Label>
                    <Form.Select name='festivalId' onChange={(e) =>valueInputChanged(e)}>
                        <option value={""}>--izaberi festiva--</option>
                        {rednerAll2()}
                    </Form.Select>
                </Form.Group>
                </Form.Group>
            </Form>}
            <br/>
             {IsLoggedIn() && <Button className="btn btn-success" onClick={() => dodajNastup()}>Kreiraj nastup</Button>}
            <Form.Group style={{marginTop:35}}>
                <Form.Check type="checkbox" label="Pretraga" onClick={(event) => setIsChecked(event.target.checked)}/>
            </Form.Group>
            <Collapse in={isChecked}>
            <Form style={{marginTop:10}}>
                <Form.Group>
                    <Form.Label>Izvodjaci</Form.Label>
                    <Form.Select name='izvodjacId' onChange={serchValue}>
                        <option value={""}>--izaberi izvodjaca--</option>
                        {rednerAll3()}
                    </Form.Select>
                    <Form.Group>
                    <Form.Label>Festivali</Form.Label>
                    <Form.Select name='festivalId' onChange={serchValue}>
                        <option value={""}>--izaberi festiva--</option>
                        {rednerAll2()}
                    </Form.Select>
                </Form.Group>
                </Form.Group>
            </Form>
            </Collapse>
          <Row>
            <Col>
              <Table>
                <thead>
                  <tr>
                    <th>Izvodjac</th>
                    <th>Festival</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  {rednerAll()}
                </tbody>
              </Table>
            </Col>
          </Row>
          <br/>
          <div style={{ display: 'flex', justifyContent: 'center' }}>
            <Button className="btn btn-light btn-sm" disabled={pageNo==0} onClick={() => getAll(pageNo-1)}>{'❮'}</Button>
            <span style={{ margin: '10px' }}> {pageNo + 1} </span> 
           <Button className="btn btn-light btn-sm" disabled={pageNo==totalPage-1 || nastupi.length === 0} onClick={() => getAll(pageNo+1)}>{'❯'}</Button>
          </div>
        </Col>
        </Row>
      </div>
    );
  }

export default Nastupi;
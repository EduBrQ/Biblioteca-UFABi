import http from './http'

const AlunosService = {
  getAll: () => {
    return http.get('/alunos')
  },
  getById: id => {
    return http.get(`/alunos/${id}`)
  },
  edit: item => {
    return http.put(`/alunos/${item.id}`, item)
  },
  create: item => {
    console.log(item)
    return http.post(`/alunos`, item)
  },
  delete: id => {
    return http.delete(`/alunos/${id}`)
  },
}

export default AlunosService
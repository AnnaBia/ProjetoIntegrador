import { Postagem } from "./Postagem"

// Classe do back-end que vai ser exportada
export class Usuario {
    public id: number
    public email: string
    public nomeCompleto: string
    public senha: string
    public admin: boolean

    // Relacionamento entre as classes
    public postagem: Postagem[]
}
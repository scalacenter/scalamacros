package scala.meta
package semantic

import scala.meta.internal.prettyprinters._

private[scala] trait Denotations { self: Universe =>
  type Denotation >: Null <: AnyRef

  implicit class XtensionDenotationsDenotation(denot: Denotation)(implicit protected val m: Mirror)
      extends SymbolBasedOps
      with MemberBasedOps[Denotation]
      with Prettyprinted {
    def sym: Symbol = abstracts.denotSym(denot)
    def info: Type = abstracts.denotInfo(denot)
    protected def syntax(p: Prettyprinter): Unit = abstracts.denotSyntax(p, denot)
    protected def structure(p: Prettyprinter): Unit = abstracts.denotStructure(p, denot)
    protected def members(f: SymFilter) = abstracts.denotMembers(denot, f)
    protected def members(name: String, f: SymFilter) = abstracts.denotMembers(denot, name, f)
  }
}
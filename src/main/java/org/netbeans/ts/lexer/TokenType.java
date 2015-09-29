package org.netbeans.ts.lexer;

public enum TokenType {

    RegularExpressionLiteral(1, "string"),
    LineTerminator(2, "line-break"),
    OpenBracket(3, "keyword"),
    CloseBracket(4, "keyword"),
    OpenParen(5, "keyword"),
    CloseParen(6, "keyword"),
    OpenBrace(7, "keyword"),
    CloseBrace(8, "keyword"),
    SemiColon(9, "keyword"),
    Comma(10, "keyword"),
    Assign(11, "keyword"),
    QuestionMark(12, "keyword"),
    Colon(13, "keyword"),
    Dot(14, "keyword"),
    PlusPlus(15, "keyword"),
    MinusMinus(16, "keyword"),
    Plus(17, "keyword"),
    Minus(18, "keyword"),
    BitNot(19, "keyword"),
    Not(20, "keyword"),
    Multiply(21, "keyword"),
    Divide(22, "keyword"),
    Modulus(23, "keyword"),
    RightShiftArithmetic(24, "keyword"),
    LeftShiftArithmetic(25, "keyword"),
    RightShiftLogical(26, "keyword"),
    LessThan(27, "keyword"),
    MoreThan(28, "keyword"),
    LessThanEquals(29, "keyword"),
    GreaterThanEquals(30, "keyword"),
    Equals(31, "keyword"),
    NotEquals(32, "keyword"),
    IdentityEquals(33, "keyword"),
    IdentityNotEquals(34, "keyword"),
    BitAnd(35, "keyword"),
    BitXOr(36, "keyword"),
    BitOr(37, "keyword"),
    And(38, "keyword"),
    Or(39, "keyword"),
    MultiplyAssign(40, "keyword"),
    DivideAssign(41, "keyword"),
    ModulusAssign(42, "keyword"),
    PlusAssign(43, "keyword"),
    MinusAssign(44, "keyword"),
    LeftShiftArithmeticAssign(45, "keyword"),
    RightShiftArithmeticAssign(46, "keyword"),
    RightShiftLogicalAssign(47, "keyword"),
    BitAndAssign(48, "keyword"),
    BitXorAssign(49, "keyword"),
    BitOrAssign(50, "keyword"),
    NullLiteral(51, "keyword"),
    BooleanLiteral(52, "keyword"),
    DecimalLiteral(53, "keyword"),
    HexIntegerLiteral(54, "keyword"),
    OctalIntegerLiteral(55, "keyword"),
    Break(56, "keyword"),
    Do(57, "keyword"),
    Instanceof(58, "keyword"),
    Typeof(59, "keyword"),
    Case(60, "keyword"),
    Else(61, "keyword"),
    New(62, "keyword"),
    Var(63, "keyword"),
    Catch(64, "keyword"),
    Finally(65, "keyword"),
    Return(66, "keyword"),
    Void(67, "keyword"),
    Continue(68, "keyword"),
    For(69, "keyword"),
    Switch(70, "keyword"),
    While(71, "keyword"),
    Debugger(72, "keyword"),
    Function(73, "keyword"),
    This(74, "keyword"),
    With(75, "keyword"),
    Default(76, "keyword"),
    If(77, "keyword"),
    Throw(78, "keyword"),
    Delete(79, "keyword"),
    In(80, "keyword"),
    Try(81, "keyword"),
    Class(82, "keyword"),
    Enum(83, "keyword"),
    Extends(84, "keyword"),
    Super(85, "keyword"),
    Const(86, "keyword"),
    Export(87, "keyword"),
    Import(88, "keyword"),
    Implements(89, "keyword"),
    Let(90, "keyword"),
    Public(92, "keyword"),
    Interface(93, "keyword"),
    Package(94, "keyword"),
    Protected(95, "keyword"),
    Static(96, "keyword"),
    Yield(97, "keyword"),
    Identifier(98, "keyword"),
    StringLiteral(99, "keyword"),
    WhiteSpaces(100, "keyword"),
    MultiLineComment(101, "keyword"),
    SingleLineComment(102, "keyword"),
    UnexpectedCharacter(103, "keyword");

    public int id;
    public String category;
    public String text;

    private TokenType(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public static TokenType valueOf(int id) {
        TokenType[] values = values();
        for (TokenType value : values) {
            if (value.id == id) {
                return value;
            }
        }
        throw new IllegalArgumentException("The id " + id + " is not recognized");
    }
}
